package com.zerodragon.demo.aop;

import com.zerodragon.demo.aop.config.AopConfig;
import com.zerodragon.demo.aop.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/14-20:03
 **/
public class AopMain {
	public static void main(String[] args) {
		annotationConfigApplicationContext();
	}

	public static void xmlApplicationContext (){
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
		MessageService messageService = xmlContext.getBean(MessageService.class);
		messageService.infoMessage();
		messageService.errorMessage();
	}

	public static void annotationConfigApplicationContext(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		MessageService messageService = applicationContext.getBean(MessageService.class);
		messageService.infoMessage();
		messageService.errorMessage();
	}
}
