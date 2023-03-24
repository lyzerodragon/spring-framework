package com.zerodragon.demo.ioc.bean.definition;

import com.zerodragon.demo.ioc.bean.Cat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/20-11:34
 **/
public class BeanDefinitionTest {
	public static final Logger log = LoggerFactory.getLogger(BeanDefinitionTest.class);

	@Test
	void beanDefinitionDiy(){
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cat.class);
		log.info("rootBeanDefinition->Cat.class:{}",rootBeanDefinition);
	}
}
