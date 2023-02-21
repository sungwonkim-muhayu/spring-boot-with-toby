package org.github.swsz2.springbootwithtoby.servlet;

import org.github.swsz2.springbootwithtoby.controller.HelloController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontControllerServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    final HelloController helloController = new HelloController();

    if ("/hello".equals(req.getRequestURI()) && HttpMethod.GET.name().equals(req.getMethod())) {
      final String name = req.getParameter("name");
      final String ret = helloController.hello(name);
      resp.setStatus(HttpStatus.OK.value());
      resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
      resp.getWriter().print(ret);
    } else if ("/user".equals(req.getRequestURI())) {
      //
    } else {
      resp.setStatus(HttpStatus.NOT_FOUND.value());
    }
  }
}
