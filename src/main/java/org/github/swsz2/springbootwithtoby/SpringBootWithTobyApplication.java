package org.github.swsz2.springbootwithtoby;

import org.github.swsz2.springbootwithtoby.controller.HelloController;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpringBootWithTobyApplication {

  public static void main(String[] args) {
    // 스프링 컨테이너에 빈 등록
    final GenericApplicationContext applicationContext = new GenericApplicationContext();
    applicationContext.registerBean(HelloController.class);
    applicationContext.refresh();

    // 빈 서블릿 컨테이너 생성
    // 서블릿 컨테이너는 어떠한 서블릿이 요청을 처리할지 매핑하는 역할을 가짐
    final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    final WebServer webServer =
        serverFactory.getWebServer(
            servletContext ->
                servletContext
                    .addServlet(
                        "frontController",
                        new HttpServlet() {
                          @Override
                          protected void service(HttpServletRequest req, HttpServletResponse resp)
                              throws ServletException, IOException {

                            if ("/hello".equals(req.getRequestURI())
                                && HttpMethod.GET.name().equals(req.getMethod())) {
                              final String name = req.getParameter("name");
                              final HelloController helloController =
                                  applicationContext.getBean(HelloController.class);
                              final String ret = helloController.hello(name);

                              resp.setStatus(HttpStatus.OK.value());
                              resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                              resp.getWriter().print(ret);
                            } else {
                              resp.setStatus(HttpStatus.NOT_FOUND.value());
                            }
                          }
                        })
                    .addMapping("/*"));
    webServer.start();
  }
}
