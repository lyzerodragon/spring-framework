package com.zerodragon.demo.ioc.run;

import com.zerodragon.demo.ioc.bean.Cat;
import com.zerodragon.demo.ioc.bean.definition.BeanDefinitionTest;
import com.zerodragon.demo.ioc.config.AnnotationConfig;
import com.zerodragon.demo.ioc.service.MessageService;
import com.zerodragon.demo.ioc.service.impl.MessageServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/20-11:43
 **/
public class IocMainTest {
	public static final Logger log = LogManager.getLogger(BeanDefinitionTest.class.getName());

	/**
	 * 注解配置应用程序上下文
	 */
	@Test
	void annotationConfigApplicationContext() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Cat cat = applicationContext.getBean(Cat.class);
		Cat cat2 = applicationContext.getBean(Cat.class);
		cat.setAge(18);
		log.info("cat.age:{}", cat2.getAge());
		log.info(cat);
		log.info(cat2);
	}

	/**
	 * xml应用程序上下文类路径
	 */
	@Test
	void classPathXmlApplicationContext() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
		MessageService messageService = context.getBean(MessageService.class);
		log.info("messageService:{}", messageService.getMessage());
	}

	/**
	 * 手动注册 Bean
	 * bean工厂注册bean定义
	 */
	@Test
	void beanFactoryRegisterBeanDefinition() {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MessageServiceImpl.class);
		final String messageServiceBeanName = "messageService";

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		beanFactory.registerBeanDefinition(messageServiceBeanName, rootBeanDefinition);
		MessageService messageService = beanFactory.getBean(messageServiceBeanName, MessageService.class);
		Assert.notNull(messageService, "手动注入失败");
		log.info("messageService.message:{}", messageService.getMessage());
	}
}
