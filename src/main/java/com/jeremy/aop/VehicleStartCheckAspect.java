package com.jeremy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1) // Control the order of which Aspect will run first in Spring context
public class VehicleStartCheckAspect {

    private Logger logger = Logger.getLogger(VehicleStartCheckAspect.class.getName());

    // Pre-method logic only (e.g., logging before execution).
    // Does not support proceed() method
    // Cannot modify return value
    @Before("execution(* com.jeremy.services.*.*(..)) && args(vehicleStarted,..)")
    public void log(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable{
        if(!vehicleStarted){
            throw new RuntimeException("Vehicle not started yet");
        }
    }
}
