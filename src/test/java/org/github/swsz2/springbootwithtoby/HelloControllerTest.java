package org.github.swsz2.springbootwithtoby;

import org.assertj.core.api.Assertions;
import org.github.swsz2.springbootwithtoby.controller.HelloController;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

  @Test
  void shouldThrowIllegalArgumentExceptionWhenEnterEmptyOrNullName() {
    final HelloController helloController = new HelloController(name -> name);
    Assertions.assertThatThrownBy(() -> helloController.hello(null))
        .isInstanceOf(IllegalArgumentException.class);

    Assertions.assertThatThrownBy(() -> helloController.hello(""))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
