package com.zerodragon.demo.ioc.service.impl;

import com.zerodragon.demo.ioc.service.MessageService;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/10-17:22
 **/

public class MessageServiceImpl implements MessageService {
	@Override
	public String getMessage() {
		return "HelloWorld";
	}
}
