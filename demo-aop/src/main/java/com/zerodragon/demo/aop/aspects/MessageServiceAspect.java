package com.zerodragon.demo.aop.aspects;

import com.zerodragon.demo.aop.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息服务方面
 *
 * @author songchenhao
 * @version : 1.0
 * @date 2022/12/14
 */
@Component
@Aspect
public class MessageServiceAspect {
	/**
	 * 日志记录器
	 */
	public static final Logger logger = LogManager.getLogger(MessageService.class.getName());
	@Pointcut("execution( * com.zerodragon.demo.aop.service.MessageService.errorMessage(..))")
	public void point(){}

	@Before("point()")
	public void before(){
		logger.warn("错误日志前置增强");
	}

	@After("point()")
	public void after(){
		logger.warn("错误日志后置增强");
	}

	@Around("point()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		logger.warn("错误日志前环绕增强");
		pjp.proceed();
		logger.warn("错误日志后环绕增强");
	}

}
