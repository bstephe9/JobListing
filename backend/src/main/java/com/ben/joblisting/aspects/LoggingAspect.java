package com.ben.joblisting.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(public * com.ben.joblisting.controller.PostController.getAllPosts())")
	public void logBefore() {
		LOGGER.info("Before method execution");
	}

	@After("execution(public * com.ben.joblisting.controller.PostController.getAllPosts())")
	public void logAfter() {
		LOGGER.info("After method execution");
	}

}
