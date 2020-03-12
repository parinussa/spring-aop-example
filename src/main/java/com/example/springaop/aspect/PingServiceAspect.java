package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PingServiceAspect {

    @Before("execution(* getPing())")
    public void checkSomethingAdvice() {
        System.out.println("(before advice) Doing some checking here...");
    }

    @After("execution(* getPing())")
    public void logDataAdvice() {
        System.out.println("(after advice) Ping service called");
    }

}
