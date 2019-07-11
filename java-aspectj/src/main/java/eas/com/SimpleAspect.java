package eas.com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SimpleAspect {

    @Before("execution (* eas.com.MyTargetClass.exampleMethod(..))")
    public void allMethods(JoinPoint joinPoint) {
        System.out.println("Method name: " + joinPoint.getSignature().getName());
    }


}
