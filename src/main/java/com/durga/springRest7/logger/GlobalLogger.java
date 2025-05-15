package com.durga.springRest7.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile(value= {"h2"})
public class GlobalLogger {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(GlobalLogger.class);
	@Pointcut("execution (* com.durga.springRest7..*(..))")
	public void pointcut() {
		
	}
	@Before("pointcut()")
	public void beforeAdvice(JoinPoint point) {
		LOGGER.info("start->"+point.getSignature());
	}
	@AfterThrowing(pointcut="pointcut()",throwing="error")
	public void afterThrow(JoinPoint point,Throwable error) {
		LOGGER.error(error.getMessage(),error);
	}
}
