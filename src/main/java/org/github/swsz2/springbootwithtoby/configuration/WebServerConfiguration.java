package org.github.swsz2.springbootwithtoby.configuration;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false) // 빈 사이의 상호 관계를 따지지 않아도 된다면 fals
public class WebServerConfiguration {
  @Bean
  public ServletWebServerFactory customWebServerFactory() {
    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
    factory.setPort(9090);
    return factory;
  }
}
