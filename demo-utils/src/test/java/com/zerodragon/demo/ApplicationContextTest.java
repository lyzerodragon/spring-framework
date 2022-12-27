package com.zerodragon.demo;

import org.junit.jupiter.api.Test;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/27-17:59
 **/
public class ApplicationContextTest {

	@Test
	public void ApplicationTest(){
		AnnotationConfigApplicationContextUtil.run(Object.class , applicationContext -> {

		});
	}
}
