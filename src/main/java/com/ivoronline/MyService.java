package com.ivoronline;

import org.springframework.stereotype.Service;

@Service
public class MyService {
  
  public String sayHello(String name, int age) {
    return "Hello " + name + ", you are " + age + " years old";
  }
  
}

