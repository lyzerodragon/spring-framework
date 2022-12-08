package com.zerodragon.demo;

import com.zerodragon.demo.bean.Cat;
import com.zerodragon.demo.config.AnnotationConfig;
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
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Cat cat = context.getBean(Cat.class);
		System.out.println(cat);
	}
}
