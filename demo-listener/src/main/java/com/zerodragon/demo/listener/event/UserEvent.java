package com.zerodragon.demo.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/22-10:06
 **/
public class UserEvent extends ApplicationEvent {
	public static final long serialVersionUID = 1L;
	public UserEvent(Object source) {
		super(source);
	}

	public void hello() {
		System.out.println("hello");
	}
}
