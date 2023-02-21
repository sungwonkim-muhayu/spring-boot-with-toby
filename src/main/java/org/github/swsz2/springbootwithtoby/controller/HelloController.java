package org.github.swsz2.springbootwithtoby.controller;

import org.github.swsz2.springbootwithtoby.service.SimpleHelloService;

import java.util.Objects;

// @RestController // html 통째로 리턴, api 요청에 대한 응답을 특정 타입으로 인코딩해 전달
public class HelloController {
  public String hello(String name) {
    final SimpleHelloService helloService = new SimpleHelloService();
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
