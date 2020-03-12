package com.example.springaop.aspect;

import com.example.springaop.model.Ping;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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

    @Around("execution(* getPing(boolean ))")
    public Object transformResultAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = new Object();

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        Ping ping = (Ping) result;

        if (ping.getPing().equals("pong")) {
            Ping peng = new Ping("peng");

            return peng;
        }

        return result;
    }

}
