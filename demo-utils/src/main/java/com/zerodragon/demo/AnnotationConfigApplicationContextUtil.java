package com.zerodragon.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Consumer;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/27-17:48
 **/
public class AnnotationConfigApplicationContextUtil {
	public static void run(Class<?> configObj, Consumer<ApplicationContext> consumer) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(configObj)) {
			consumer.accept(applicationContext);
		}
	}


}