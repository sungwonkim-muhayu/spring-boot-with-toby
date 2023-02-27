package org.github.swsz2.configuration.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 스프링 컨테이너야. 구성 정보를 가지고 있는 클래스니까, 안에 설정된 빈 오브젝트를 만들어줘!
public class DispatcherServletConfiguration {
  @Bean
  public DispatcherServlet dispatcherServlet() {
    // 스프링 컨테이너에 의해 ApplicationContextAware.setApplicationContext()에서 애플리케이션 컨텍스트를 주입 받음
    return new DispatcherServlet();
  }
}
