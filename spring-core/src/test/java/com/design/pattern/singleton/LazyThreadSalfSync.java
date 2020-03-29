package com.design.pattern.singleton;

/**
 * @ClassName LazyThreadSalfSync
 * @Description 懒汉-单例模式-线程安全-synchronized
 * @Author Jacob
 * @Date 2020/3/27 21:13
 */
public class LazyThreadSalfSync {

	//静态变量私有化
	private static LazyThreadSalfSync lazy;

	//构造方法私有化，只允许内部实例化
	private LazyThreadSalfSync() {
	}

	//通过同步方法，将此方法整体加锁，此时该方法线程安全
	//但是此方法极其耗费资源，每次都要走锁验证，所以不推荐该方法使用
	public synchronized static LazyThreadSalfSync getInstance() {
		if (lazy == null) {
			lazy = new LazyThreadSalfSync();
		}
		return lazy;
	}
}
