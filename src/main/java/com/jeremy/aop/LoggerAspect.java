package com.jeremy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2) // Control the order of which Aspect will run first in Spring context
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    // Full control over pre- and post-method logic; can modify behavior/results
    // Support proceed() method
    // CAN modify return value
//    @Around("execution(* com.jeremy.services.*.*(..))")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
//        logger.info(joinPoint.getSignature().toLongString()+ " method execution start");
//        Instant start = Instant.now();
//        Object result = joinPoint.proceed();
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start,finish).toMillis();
//        logger.info("Time took to execute the method in mile seconds: "+timeElapsed);
//        logger.info(joinPoint.getSignature().toLongString() + " method execution end.");
//        return result;
//    }

    // Full control over pre- and post-method logic; can modify behavior/results
    // Support proceed() method
    // CAN modify return value
    // But use Annotation to locate
    @Around("@annotation(com.jeremy.aop.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.toString() + " method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        logger.info(joinPoint.getSignature().toString() + " method execution end");
    }

    // Logic that executes when a method throws an exception.
    // Does not support proceed() method
    // CANNOT modify return value
    @AfterThrowing(value = "@annotation(com.jeremy.aop.LogAspect)",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE,joinPoint.getSignature()+ " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+ex.getMessage());
    }

    // Logic that executes when a method throws an exception.
    // Does not support proceed() method
    // CAN modify return value
    @AfterReturning(value = "@annotation(com.jeremy.aop.LogAspect)",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,Object retVal) {
        logger.log(Level.INFO,joinPoint.getSignature()+ " Method successfully processed with the status " +
                retVal.toString());
    }
}
