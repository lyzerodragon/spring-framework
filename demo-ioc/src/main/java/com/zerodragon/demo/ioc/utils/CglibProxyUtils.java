package com.zerodragon.demo.ioc.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/21-9:42
 **/
public class CglibProxyUtils implements MethodInterceptor {
	/**
	 * 目标对象
	 */
	private Object target;

	public CglibProxyUtils(Object target) {
		this.target = target;
	}

	/**
	 * 代理对象方法拦截器
	 *
	 * @param o           代理对象
	 * @param method      被代理的类的方法，
	 * @param objects     调用方法传递的参数
	 * @param methodProxy 方法代理对象
	 * @return {@link Object}
	 * @throws Throwable throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("执行方法"+method.getName());
		System.out.println(method.getName()+"-before...");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println(method.getName()+"-after...");
		return result;
	}

	public static Object createProxy(Object target) {
		CglibProxyUtils cglibProxy = new CglibProxyUtils(target);
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(cglibProxy);
		enhancer.setSuperclass(target.getClass());
		return enhancer.create();
	}
}
