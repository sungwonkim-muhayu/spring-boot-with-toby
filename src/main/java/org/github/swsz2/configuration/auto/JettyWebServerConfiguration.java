package org.github.swsz2.configuration.auto;

import org.github.swsz2.configuration.ConditionalMyOnClass;
import org.github.swsz2.configuration.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfiguration {
  @Bean("jettyServerFactory")
  @ConditionalOnMissingBean // 동일한 타입의 빈이 존재하지 않는다면, 해당 빈을 적용
  public ServletWebServerFactory servletWebServerFactory() {
    return new JettyServletWebServerFactory();
  }

  //  static class JettyCondition implements Condition {
  //    @Override
  //    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
  //      return ClassUtils.isPresent("org.eclipse.jetty.server.Server", context.getClassLoader());
  //    }
  //  }
}
