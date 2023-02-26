package org.github.swsz2.springbootwithtoby;

import org.github.swsz2.springbootwithtoby.annotation.MySpringBootAnnotation;
import org.springframework.boot.SpringApplication;

@MySpringBootAnnotation
public class SpringBootWithTobyApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootWithTobyApplication.class, args);
  }
}
