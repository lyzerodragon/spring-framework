package com.zerodragon.demo.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-11:55
 **/
@Component
public class OutBeanNameBeanPostProcessor implements BeanPostProcessor {

	public static final Logger log = LoggerFactory.getLogger(OutBeanNameBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("beanName: {}, beanClass: {}", beanName, bean.getClass());
		return bean;
	}
}
