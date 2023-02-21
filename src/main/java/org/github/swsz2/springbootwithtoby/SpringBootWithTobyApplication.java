package org.github.swsz2.springbootwithtoby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
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

  private static class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
      final String name = req.getParameter("name");
      resp.setStatus(HttpStatus.OK.value());
      resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
      resp.getWriter().print("hello servlet" + name);
    }
  }

  private static class FrontControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
      if ("/hello".equals(req.getRequestURI()) && HttpMethod.GET.name().equals(req.getMethod())) {
        final String name = req.getParameter("name");
        resp.setStatus(HttpStatus.OK.value());
        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        resp.getWriter().print("hello servlet " + name);
      } else if ("/user".equals(req.getRequestURI())) {
        //
      } else {
        resp.setStatus(HttpStatus.NOT_FOUND.value());
      }
    }
  }
}
