package com.design.pattern.singleton;

/**
 * @ClassName LazyDoubleCheck
 * @Description 懒汉-单例模式-线程安全-双重锁机制
 * @Author Jacob
 * @Date 2020/3/27 22:38
 */
public class LazyDoubleCheck {

	//使用volatile关键字保证内存可见性，先写后读
	private volatile static LazyDoubleCheck lazy;

	//构造方法私有化，只允许内部实例化
	private LazyDoubleCheck() {
	}

	//该方法使用两个 lazy == null 来校验，所以被称为双重锁
	//该方法近似完美地解决了问题，将代码同步块单独加载初始化上，仅消耗了一次初始化的资源
	//这是一种在临界区代码加锁的方法
	//除非lazy使用volatile关键字，保证先写后查，否则会出现一个线程拿到了初始化一半的实例
	public static LazyDoubleCheck getInstance() {
		if (lazy == null) {
			synchronized (LazyDoubleCheck.class) {
				if (lazy == null) {
					lazy = new LazyDoubleCheck();
				}
			}
		}
		return lazy;
	}
}
