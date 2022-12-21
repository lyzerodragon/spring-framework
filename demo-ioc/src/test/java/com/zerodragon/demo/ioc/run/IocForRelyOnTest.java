package com.zerodragon.demo.ioc.run;

import com.zerodragon.demo.ioc.demo.BeanA;
import com.zerodragon.demo.ioc.demo.BeanB;
import com.zerodragon.demo.ioc.utils.CglibProxyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ioc 容器 循环依赖
 *
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/20-21:38
 **/
public class IocForRelyOnTest {

	/**
	 * bean definition map
	 */
	public static final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(255);

	/**
	 * 单例对象
	 * 一级缓存
	 */
	public static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

	/**
	 * 早期单例对象
	 * 二级缓存
	 */
	public static final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();

	static {
		// 初始化 BeanDefinitionMap
		beanDefinitionMap.put("beanA", new RootBeanDefinition(BeanA.class));
		beanDefinitionMap.put("beanB", new RootBeanDefinition(BeanB.class));
	}

	/**
	 * 循环依赖
	 */
	@Test
	void forRelyOn() throws Exception {
		BeanA beanA = (BeanA) getBean("beanA");
		BeanB beanB = (BeanB) getBean("beanB");
		beanA.showClass();
		beanB.showClass();
	}

	Object getBean(String beanName) throws Exception {
		// 首先先查看缓存中是否存在Bean
		Object singleton = getSingleton(beanName);
		if (singleton != null) {
			return singleton;
		}

		// 获取 BeanDefinition
		RootBeanDefinition beanDef = (RootBeanDefinition) beanDefinitionMap.get(beanName);
		Class<?> beanClass = beanDef.getBeanClass();
		// 实例化
		Object beanInstance = beanClass.newInstance();

		// 动态代理
		// ...
		beanInstance = proxy(beanInstance);

		// 添加到二级缓存
		earlySingletonObjects.put(beanName, beanInstance);

		// 属性赋值
		for (Field declaredField : beanClass.getDeclaredFields()) {
			Autowired autowired = declaredField.getAnnotation(Autowired.class);
			if (autowired != null) {
				declaredField.setAccessible(true);
				declaredField.set(beanInstance, getBean(declaredField.getName()));
			}
		}

		// 存到一级缓存
		singletonObjects.put(beanName, beanInstance);
		return beanInstance;
	}

	/**
	 * 代理 模拟Aop的 postProcessor
	 *
	 * @param o o
	 * @return {@link Object}
	 */
	private Object proxy(Object o) {
		if (o instanceof BeanA) {
			return CglibProxyUtils.createProxy(o);
		}
		return o ;
	}


	/**
	 * 获取单例
	 *
	 * @param beanName bean名字
	 * @return {@link Object}
	 */
	Object getSingleton(String beanName) {
		if (singletonObjects.containsKey(beanName)) {
			// 从一级缓存中拿
			return singletonObjects.get(beanName);
		} else if (earlySingletonObjects.containsKey(beanName)) {
			// 从二级缓存拿
			return earlySingletonObjects.get(beanName);
		}

		return null;
	}

}
