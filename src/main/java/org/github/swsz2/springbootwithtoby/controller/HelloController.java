package org.github.swsz2.springbootwithtoby.controller;

import org.github.swsz2.springbootwithtoby.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController // html 통째로 리턴, api 요청에 대한 응답을 특정 타입으로 인코딩해 전달
@RequestMapping // 빈이 많아지면 탐색하기 힘드니, 클래스 레벨에서 먼저 찾을 수 있도록 RequestMapping 선언
@Controller
public class HelloController {

  // 초창기에는 xml 기반으로 빈을 주입했음
  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  // 디스패처 서블릿이 스프링 컨테이너 안에서 웹 요청을 처리할 수 있는 매핑 정보를 찾아 요청 정보를 추출해 매핑 테이블 생성 <br>
  // 기본적으로 String return일 경우 view를 탐색해서 반환하려고 함, 따라서 api 요청에 대한 응답을 특정 타입(String)으로 인코딩해 전달할 수
  // 있도록 @ResponseBody 추가 <br>
  @GetMapping("/hello")
  @ResponseBody
  public String hello(String name) {

    if (!StringUtils.hasText(name)) {
      throw new IllegalArgumentException();
    }

    return helloService.sayHello(name);
  }
}
