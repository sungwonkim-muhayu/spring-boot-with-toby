package org.github.swsz2.springbootwithtoby.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

  @Test
  void configuration() {}

  // Configuration으로 등록하면 스프링 컨테이너가 proxy로 구현하여 사용함
  static class MyConfigurationProxy extends MyConfiguration {
    private Common common;

    @Override
    Common common() {
      if (this.common == null) this.common = super.common();
      return this.common;
    }
  }

  @Configuration
  // @Configuration(proxyBeanMethods = false) //proxyBeanMethods를 false로 할 경우, 프록시를 사용하지 않음
  static class MyConfiguration {
    @Bean
    Common common() {
      return new Common();
    }

    @Bean
    Bean1 bean1() {
      return new Bean1(common());
    }

    @Bean
    Bean2 bean2() {
      return new Bean2(common());
    }
  }

  static class Bean1 {
    private final Common common;

    Bean1(Common common) {
      this.common = common;
    }
  }

  static class Bean2 {
    private final Common common;

    Bean2(Common common) {
      this.common = common;
    }
  }

  static class Common {}

  // Bean1 <-- Common
  // Bean2 <-- Common
}
