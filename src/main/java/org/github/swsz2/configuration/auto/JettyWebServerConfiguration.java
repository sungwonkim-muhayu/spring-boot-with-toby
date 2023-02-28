package org.github.swsz2.configuration.auto;

import org.github.swsz2.configuration.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

@MyAutoConfiguration
@Conditional(JettyWebServerConfiguration.JettyCondition.class)
public class JettyWebServerConfiguration {
  @Bean("jettyServerFactory")
  public ServletWebServerFactory servletWebServerFactory() {
    return new JettyServletWebServerFactory();
  }

  static class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      return true;
    }
  }
}
