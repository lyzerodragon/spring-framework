package com.zerodragon.demo.test.canine;

import com.zerodragon.demo.test.Canine;

/**
 * 类声明:&nbsp;
 *
 * @author zeroDragon
 * @date 2022/12/8
 */
public class GoldenRetriever extends Canine {
	public GoldenRetriever() {
		System.out.println("子类无参构造");
	}

	public GoldenRetriever(String name, Integer age) {
		System.out.println("子类有参构造");
	}
}
