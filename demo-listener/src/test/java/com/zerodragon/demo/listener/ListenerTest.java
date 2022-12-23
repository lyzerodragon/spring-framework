package com.zerodragon.demo.listener;

import com.zerodragon.demo.listener.event.UserEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/22-10:07
 **/
public class ListenerTest {
	@Test
	public void listenerTest(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zerodragon.demo");

		UserEvent userEvent = new UserEvent(this);

		applicationContext.publishEvent(userEvent);
	}
}
