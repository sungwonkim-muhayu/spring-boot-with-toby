package org.github.swsz2.springbootwithtoby.controller;

// @RestController // html 통째로 리턴, api 요청에 대한 응답을 특정 타입으로 인코딩해 전달
public class HelloController {
  public String hello(String name) {
    return "hello " + name;
  }
}
