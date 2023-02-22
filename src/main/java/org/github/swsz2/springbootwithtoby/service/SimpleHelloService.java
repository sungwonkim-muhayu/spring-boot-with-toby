package org.github.swsz2.springbootwithtoby.service;

public class SimpleHelloService implements HelloService {
  @Override
  public String sayHello(final String name) {
    return "hello " + name;
  }
}
