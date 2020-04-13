package com.design.pattern.proxy;

/**
 * @ClassName Zhangsan
 * @Description 张三
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 8:36
 **/
public class Zhangsan implements Person {

	@Override
	public void findLove() {
		System.out.println("I want to find a beautiful girl! She has big eyes!");
	}
}
