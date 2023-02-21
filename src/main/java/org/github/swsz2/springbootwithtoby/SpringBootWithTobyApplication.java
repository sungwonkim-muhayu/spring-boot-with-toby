package org.github.swsz2.springbootwithtoby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpringBootWithTobyApplication {

  public static void main(String[] args) {
    // 빈 서블릿 컨테이너 생성
    // 서블릿 컨테이너는 어떠한 서블릿이 요청을 처리할지 매핑하는 역할을 가짐
    final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    final WebServer webServer =
        serverFactory.getWebServer(servletContext
                -> servletContext.addServlet("hello",new HttpServlet() {
                          @Override
                          protected void service(HttpServletRequest req, HttpServletResponse resp)
                              throws ServletException, IOException {
                            resp.setStatus(200);
                            resp.setHeader("Content-Type", "text/plain");
                            resp.getWriter().print("hello servlet");
                          }
                        })
                    .addMapping("/hello"));
    webServer.start();
  }
}
