package com.zerodragon.demo;

import com.zerodragon.demo.bean.Cat;
import com.zerodragon.demo.config.AnnotationConfig;
import com.zerodragon.demo.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类声明:&nbsp;
 *
 * @author zeroDragon
 * @date 2022/12/4
 */
public class Main {
	/**
	 * 日志记录器
	 */
	public static final Logger logger = LogManager.getLogger(Main.class.getName());
	public static void main(String[] args) {
		startLog();
		annotationConfigApplicationContext();
//		classPathXmlApplicationContext();
		stopLog();
	}

	/**
	 * 注释配置应用程序上下文
	 */
	public static void annotationConfigApplicationContext(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Cat cat = context.getBean(Cat.class);
		System.out.println(cat);
	}

	/**
	 * xml应用程序上下文类路径
	 */
	public static void classPathXmlApplicationContext(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
		MessageService messageService = context.getBean(MessageService.class);
		logger.info("messageService:{}",messageService.getMessage());
	}



	/**
	 * 启动日志
	 */
	public static void startLog() {
		logger.info("============================================= start OK! =============================================");
	}

	/**
	 * 停止日志
	 */
	public static void stopLog() {
		logger.info("============================================= stop OK! =============================================");
	}
}
