package org.github.swsz2.springbootwithtoby.configuration;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 스프링 컨테이너야. 구성 정보를 가지고 있는 클래스니까, 안에 설정된 빈 오브젝트를 만들어줘!
public class Config {

  @Bean
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }

  @Bean
  public DispatcherServlet dispatcherServlet() {
    // 스프링 컨테이너에 의해 ApplicationContextAware.setApplicationContext()에서 애플리케이션 컨텍스트를 주입 받음
    return new DispatcherServlet();
  }
}
