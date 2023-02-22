package org.github.swsz2.springbootwithtoby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 스프링 컨테이너야. 구성 정보를 가지고 있는 클래스니까, 안에 설정된 빈 오브젝트를 만들어줘!
@ComponentScan // 하위 패키지에 포함되는, 컴포넌트 어노테이션이 붙은 클래스를 빈으로 등록해줘!
public class SpringBootWithTobyApplication {

  // @Bean
  //// 스프링 컨테이너야. 내가 헬로 컨트롤러 만들 건데 그때 필요한 의존성을 알아서 주입해줘
  // public HelloController helloController(HelloService helloService) {
  //  return new HelloController(helloService);
  // }
  // @Bean
  // public HelloService helloService() {
  //  return new SimpleHelloService();
  // }

  @Bean
  public ServletWebServerFactory servletWebServerFactory() {
    return new TomcatServletWebServerFactory();
  }

  @Bean
  public DispatcherServlet dispatcherServlet() {
    // 스프링 컨테이너에 의해 ApplicationContextAware.setApplicationContext()에서 애플리케이션 컨텍스트를 주입 받음
    return new DispatcherServlet();
  }

  public static void main(String[] args) {
    // MySpringApplication.run(SpringBootWithTobyApplication.class, args);
    SpringApplication.run(SpringBootWithTobyApplication.class, args);
  }
}
