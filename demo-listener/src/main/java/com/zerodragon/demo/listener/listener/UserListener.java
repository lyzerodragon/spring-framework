package com.zerodragon.demo.listener.listener;

import com.zerodragon.demo.listener.event.UserEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/22-10:06
 **/
@Configuration
public class UserListener {
	@EventListener(UserEvent.class)
	public void listenerUser(UserEvent event){
		event.hello();
	}
}
