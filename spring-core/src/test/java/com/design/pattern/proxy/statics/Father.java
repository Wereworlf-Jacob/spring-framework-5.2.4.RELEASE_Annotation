package com.design.pattern.proxy.statics;

import com.design.pattern.proxy.Zhangsan;

/**
 * @ClassName Father
 * @Description 张三的父亲，给张三代理找对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 8:57
 **/
public class Father {

	private Zhangsan zhangsan;

	public Father(Zhangsan zhangsan) {
		this.zhangsan = zhangsan;
	}

	public void findLove() {
		System.out.println("go to find many girl");
		zhangsan.findLove();
		System.out.println("ask zhangsan how?");
	}

}
