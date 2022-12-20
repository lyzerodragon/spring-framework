package com.zerodragon.demo.ioc.bean.definition;

import com.zerodragon.demo.ioc.bean.Cat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/20-11:34
 **/
public class BeanDefinitionTest {
	public static final Logger logger = LogManager.getLogger(BeanDefinitionTest.class.getName());

	@Test
	void beanDefinitionDiy(){
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cat.class);
		logger.info("rootBeanDefinition->Cat.class:{}",rootBeanDefinition);
	}
}
