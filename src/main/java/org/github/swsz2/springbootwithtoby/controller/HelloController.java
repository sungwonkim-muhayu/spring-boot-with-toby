package org.github.swsz2.springbootwithtoby.controller;

import org.github.swsz2.springbootwithtoby.service.HelloService;

import java.util.Objects;

// @RestController // html 통째로 리턴, api 요청에 대한 응답을 특정 타입으로 인코딩해 전달
public class HelloController {

  // 초창기에는 xml 기반으로 빈을 주입했음
  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  public String hello(String name) {
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
