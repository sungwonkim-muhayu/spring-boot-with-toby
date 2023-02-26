package org.github.swsz2.springbootwithtoby;

import org.assertj.core.api.Assertions;
import org.github.swsz2.springbootwithtoby.service.HelloService;
import org.github.swsz2.springbootwithtoby.service.SimpleHelloService;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@UnitTest
@interface FastUnitTest {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {}

public class HelloServiceTest {

  @Test
  // @UnitTest
  // @FastUnitTest
  void shouldPassWhenEqualsSimpleHelloServiceHelloAndExpectedValue() {
    final HelloService helloService = new SimpleHelloService();
    final String result = helloService.sayHello("Spring");
    Assertions.assertThat(result).isEqualTo("hello Spring");
  }
}
