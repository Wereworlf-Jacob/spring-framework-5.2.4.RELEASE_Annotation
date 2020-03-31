package com.design.pattern.singleton;

/**
 * @ClassName LazyThreadUnsale
 * @Description 懒汉-单例模式（线程非安全版）
 * @Author Jacob
 * @Date 2020/3/27 21:06
 */
public class LazyThreadUnsale {

	//静态变量私有化
	private static LazyThreadUnsale lazy;

	//构造方法私有化，只允许内部实例化
	private LazyThreadUnsale() {
	}

	//静态获取实例的方法公有化
	//在即将使用的时候，再创建类，但是有线程安全问题
	public static LazyThreadUnsale getInstance() {
		if (lazy == null) {
			lazy = new LazyThreadUnsale();
		}
		return lazy;
	}

}
