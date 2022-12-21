package com.zerodragon.demo.ioc.demo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/20-21:34
 **/
public class BeanA {
	@Autowired
	private BeanB beanB;

	public void showClass() {
		System.out.println(getClass().getSimpleName() + ".'beanB' is not null is " + (beanB != null));
	}
}
