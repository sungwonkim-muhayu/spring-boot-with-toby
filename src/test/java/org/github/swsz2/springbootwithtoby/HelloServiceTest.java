package org.github.swsz2.springbootwithtoby;

import org.assertj.core.api.Assertions;
import org.github.swsz2.springbootwithtoby.service.HelloService;
import org.github.swsz2.springbootwithtoby.service.SimpleHelloService;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

  @Test
  void shouldPassWhenEqualsSimpleHelloServiceHelloAndExpectedValue() {
    final HelloService helloService = new SimpleHelloService();
    final String result = helloService.sayHello("Spring");
    Assertions.assertThat(result).isEqualTo("hello Spring");
  }
}
