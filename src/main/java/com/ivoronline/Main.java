package com.ivoronline;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
  
      ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                                     context.registerShutdownHook();

      MyService myService = context.getBean("myService", MyService.class);
                myService.sayHello("Jill", 50);

      context.close();
      
  }
  
}