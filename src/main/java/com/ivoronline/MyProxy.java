package com.ivoronline;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyProxy {

  @Pointcut("within(com.ivoronline.*)")
  public void logMethodPointCut() { }
  
  @Before("logMethodPointCut()")
  public void logBeforeMethodCall(JoinPoint joinPoint) throws Throwable {
    Signature signature  = joinPoint.getSignature();
    String    methodName = signature.getName();
    System.out.println("Before   Method: " + methodName);
  }
  
  @After("logMethodPointCut()")
  public void logAfterMethodCall(JoinPoint joinPoint) {
    Signature signature  = joinPoint.getSignature();
    String    methodName = signature.getName();
    System.out.println("After    Method: " + methodName);
  }
  
  @Around("logMethodPointCut()")
  public void logAroundMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  
    //PRE PROCESSING
    Signature signature  = proceedingJoinPoint.getSignature();
    String    methodName = signature.getName();
    System.out.println("Entering Method: " + methodName);
    
    //CALL METHOD
    Object result = proceedingJoinPoint.proceed();
    
    //POST PROCESSING
    System.out.print("Exiting  Method: " + methodName);
    System.out.println(" => " + result);

  }
  
}
