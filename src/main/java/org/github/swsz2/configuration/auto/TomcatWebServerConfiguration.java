package org.github.swsz2.configuration.auto;

import org.github.swsz2.configuration.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Conditional(TomcatWebServerConfiguration.TomcatCondition.class)
@MyAutoConfiguration // 스프링 컨테이너야. 구성 정보를 가지고 있는 클래스니까, 안에 설정된 빈 오브젝트를 만들어줘!
public class TomcatWebServerConfiguration {
  @Bean("tomcatServerFactory")
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }

  static class TomcatCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      return false;
    }
  }
}
