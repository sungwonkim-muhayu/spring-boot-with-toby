package org.github.swsz2.springbootwithtoby;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
  public static void run(Class<?> applicationClass, String[] args) {
    // 서블릿 컨테이너 초기화를 onRefresh 안에서 수행
    final AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext() {
          @Override
          protected void onRefresh() {
            super.onRefresh();
            // 빈 서블릿 컨테이너 생성
            // 서블릿 컨테이너는 어떠한 서블릿이 요청을 처리할지 매핑하는 역할을 가짐
            final ServletWebServerFactory serverFactory =
                this.getBean(ServletWebServerFactory.class);
            final DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

            final WebServer webServer =
                serverFactory.getWebServer(
                    servletContext ->
                        servletContext
                            // 프론트 컨트롤러의 역할을 디스패처 서블릿이 대신 처리할 수 있도록 함
                            .addServlet("dispatcherServlet", dispatcherServlet)
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
