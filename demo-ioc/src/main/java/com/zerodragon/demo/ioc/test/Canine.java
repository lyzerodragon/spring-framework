package com.zerodragon.demo.ioc.test;

/**
 * 类声明:&nbsp; 犬科动物
 *
 * @author zeroDragon
 * @date 2022/12/8
 */
public class Canine extends Animal{
	private String name ;

	public Canine() {
		System.out.println("not params constructor");
	}

	public Canine(String name,Integer age) {
		this.name = name;
		setAge(age);

		System.out.println("params constructor");
	}


	@Override
	public String getType() {
		return "canine";
	}
}
