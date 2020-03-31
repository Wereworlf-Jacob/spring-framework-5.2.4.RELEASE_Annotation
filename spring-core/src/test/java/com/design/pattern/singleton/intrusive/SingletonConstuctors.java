package com.design.pattern.singleton.intrusive;

/**
 * @ClassName SingletonConstuctors
 * @Description 防止通过构造方法侵入的单例类
 * @Author Jacob
 * @Date 2020/3/31 13:48
 * @Version 1.0
 **/
public class SingletonConstuctors {

	private static boolean initialized = false;

	private static SingletonConstuctors singleton = new SingletonConstuctors();

	private SingletonConstuctors() {
		//定义一个是否初始化的标识
		synchronized (SingletonConstuctors.class) {
			if (!initialized) { //如果该类没有初始化过，那么就初始化，同时标志设置为true
				initialized = !initialized;
			} else { //否则，说明该类已经初始化过 ，那么抛出异常
				throw new RuntimeException("the SingletonConstuctors is load, can't repeat new ");
			}
		}
	}

	public static SingletonConstuctors getInstance() {
		return singleton;
	}
}
