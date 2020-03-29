package com.design.pattern.singleton;

/**
 * @ClassName LazyStaticInnerClass
 * @Description 懒汉-单例模式-线程安全-通过静态内部匿名类实例化
 * @Author Jacob
 * @Date 2020/3/27 23:11
 */
public class LazyStaticInnerClass {

	private LazyStaticInnerClass() {
	}

	//静态内部类，不属于类的静态资源，不会在类信息加载的时候触发
	// 而是在使用该类的方法触发后，才会触发，所以可以保证是懒汉加载
	public static final LazyStaticInnerClass getInstance() {
		return LazyHolder.lazy;
	}

	//因为该类中，有静态属性，所以会再执行静态属性的赋值
	//所以就可以通过LazyHolder.lazy获取到一个单例的对象
	private static class LazyHolder {
		static final LazyStaticInnerClass lazy = new LazyStaticInnerClass();
	}
}
