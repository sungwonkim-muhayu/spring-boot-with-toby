package org.github.swsz2.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan // 하위 패키지에 포함되는, 컴포넌트 어노테이션이 붙은 클래스를 빈으로 등록해줘!
@EnableHelloAutoConfiguration
public @interface MySpringBootApplication {}
