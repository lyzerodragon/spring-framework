package com.zerodragon.demo.ioc.config;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/12-19:44
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.core.PriorityOrdered;

@Configuration
public class MybatisConfig implements PriorityOrdered {
	@Override
	public int getOrder() {
		return 1;
	}
}
