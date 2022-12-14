package com.zerodragon.demo.ioc.config;

import com.zerodragon.demo.ioc.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类声明:&nbsp; 注解式配置bean
 *
 * @author zeroDragon
 * @date 2022/12/4
 */
@Configuration
@ComponentScan("com.zerodragon.demo")
public class AnnotationConfig {
	@Bean
	public Cat cat(){
		return new Cat();
	}
}
