package org.github.swsz2.springbootwithtoby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** */
@RestController // html 통째로 리턴, api 요청에 대한 응답을 특정 타입으로 인코딩해 전달
public class HelloController {

  @GetMapping(value = "/hello")
  public String hello(String name) {
    return "hello " + name;
  }
}
