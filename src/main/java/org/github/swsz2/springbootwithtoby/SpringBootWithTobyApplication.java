package org.github.swsz2.springbootwithtoby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
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

  public static void main(String[] args) {

    // 서블릿 컨테이너 초기화를 onRefresh 안에서 수행
    final AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext() {
          @Override
          protected void onRefresh() {
            super.onRefresh();
            // 빈 서블릿 컨테이너 생성
            // 서블릿 컨테이너는 어떠한 서블릿이 요청을 처리할지 매핑하는 역할을 가짐
            final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
            final WebServer webServer =
                serverFactory.getWebServer(
                    servletContext ->
                        servletContext
                            // 프론트 컨트롤러의 역할을 디스패처 서블릿이 대신 처리할 수 있도록 함
                            .addServlet("dispatcherServlet", new DispatcherServlet(this))
                            .addMapping("/*"));
            webServer.start();
          }
        };
    // 스프링 컨테이너에 빈 등록 (GenericWebApplicationContext)
    // applicationContext.registerBean(HelloController.class);
    // applicationContext.registerBean(SimpleHelloService.class);

    // 어노테이션 기반 빈 등록 (AnnotationConfigWebApplicationContext)
    applicationContext.register(SpringBootWithTobyApplication.class);
    applicationContext.refresh();
  }
}
