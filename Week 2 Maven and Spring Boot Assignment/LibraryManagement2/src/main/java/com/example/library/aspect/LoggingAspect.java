package com.example.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.library.service.*.*(..))")
    public void logBeforeMethodExecution() {
        logger.info("A method in the service layer is about to be executed.");
    }

    @After("execution(* com.example.library.service.*.*(..))")
    public void logAfterMethodExecution() {
        logger.info("A method in the service layer has been executed.");
    }
}
