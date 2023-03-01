package org.github.swsz2.configuration.auto;

import org.github.swsz2.configuration.ConditionalMyOnClass;
import org.github.swsz2.configuration.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@MyAutoConfiguration // 스프링 컨테이너야. 구성 정보를 가지고 있는 클래스니까, 안에 설정된 빈 오브젝트를 만들어줘!
public class TomcatWebServerConfiguration {
  @Bean("tomcatServerFactory")
  @ConditionalOnMissingBean // 동일한 타입의 빈이 존재하지 않는다면, 해당 빈을 적용
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }
  //
  //  static class TomcatCondition implements Condition {
  //    @Override
  //    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
  //      return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
  // context.getClassLoader());
  //    }
  //  }
}
