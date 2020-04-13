package com.design.pattern.proxy.statics;

import com.design.pattern.proxy.Zhangsan;

/**
 * @ClassName StaticProxyTest
 * @Description 静态代理测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 8:59
 **/
public class StaticProxyTest {

	public static void main(String[] args) {
		Father father = new Father(new Zhangsan());
		father.findLove();
		//如此便实现了一个简单的静态代理
		//但是如上使用，会有一个问题就是当张三需要扩展方法的时候，那么该代理类需要同时扩展方法
		//同时该代理类只能为张三代理，当李四也需要找对象的时候，就需要李四的父亲去代理，张三的父亲是无法代理的
	}

}
