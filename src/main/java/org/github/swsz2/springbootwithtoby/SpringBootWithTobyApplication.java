package org.github.swsz2.springbootwithtoby;

import org.github.swsz2.springbootwithtoby.servlet.FrontControllerServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class SpringBootWithTobyApplication {

  public static void main(String[] args) {
    // 빈 서블릿 컨테이너 생성
    // 서블릿 컨테이너는 어떠한 서블릿이 요청을 처리할지 매핑하는 역할을 가짐
    final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    final WebServer webServer =
        serverFactory.getWebServer(
            servletContext ->
                servletContext
                    .addServlet("frontController", new FrontControllerServlet())
                    .addMapping("/*"));
    webServer.start();
  }
}
