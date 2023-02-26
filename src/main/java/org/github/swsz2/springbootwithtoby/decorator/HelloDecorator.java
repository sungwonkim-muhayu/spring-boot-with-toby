package org.github.swsz2.springbootwithtoby.decorator;

import org.github.swsz2.springbootwithtoby.service.HelloService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // HelloService를 필요로 하는 빈을 생성할 떄, 우선적으로 선택되도록 선언
public class HelloDecorator implements HelloService {

  private final HelloService helloService;

  public HelloDecorator(HelloService helloService) {
    this.helloService = helloService;
  }

  @Override
  public String sayHello(String name) {
    return "*" + helloService.sayHello(name) + "*";
  }
}
