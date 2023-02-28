package org.github.swsz2.springbootwithtoby.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ConditionalTest {

  @Test
  void conditional() {
    new ApplicationContextRunner()
        .withUserConfiguration(Config1.class)
        .run(
            context -> {
              Assertions.assertThat(context).hasSingleBean(MyBean.class);
              Assertions.assertThat(context).hasSingleBean(Config1.class);
            });

    new ApplicationContextRunner()
        .withUserConfiguration(Config2.class)
        .run(
            context -> {
              Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
              Assertions.assertThat(context).doesNotHaveBean(Config2.class);
            });
  }

  static class MyBean {}

  @Configuration
  @BooleanConditional(true)
  static class Config1 {
    @Bean
    MyBean myBean() {
      return new MyBean();
    }
  }

  @Configuration
  @BooleanConditional(false)
  static class Config2 {
    @Bean
    MyBean myBean() {
      return new MyBean();
    }
  }

  static class TrueCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      return true;
    }
  }

  static class FalseCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      return false;
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Conditional(BooleanCondition.class)
  @interface BooleanConditional {
    boolean value();
  }

  static class BooleanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      try {
        return (Boolean)
            metadata.getAnnotationAttributes(BooleanConditional.class.getName()).get("value");
      } catch (Exception exception) {
        return false;
      }
    }
  }
}
