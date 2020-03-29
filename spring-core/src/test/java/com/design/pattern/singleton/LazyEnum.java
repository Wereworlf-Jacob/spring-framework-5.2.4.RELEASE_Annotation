package com.design.pattern.singleton;

/**
 * @ClassName LazyEnum
 * @Description 懒汉-单例模式-枚举实现
 * @Author Jacob
 * @Date 2020/3/27 22:50
 */
public class LazyEnum {

	//构造方法私有化，只允许内部实例化
	private LazyEnum() {
	}

	//私有化内部类，不允许外部获取该类
	private enum SingletonEnum{
		//枚举机制，使其在加载类信息的时候，就会自动创建一个对象
		//同时保证该对象必然使单例的
		INSTANCE;
		//定义枚举类的属性，是一个我们需要进行单例化的一个实例
		private LazyEnum lazy;
		//定义枚举类的构造方法，因为枚举机制，对象为单例创建，该构造方法仅执行一次
		//故而保证需要单例化的懒汉实例，也是仅创建一次
		//并且是在SingletonEnum加载类信息时，该LazyEnum对象，进行单例模式实例化
		SingletonEnum() {
			this.lazy = new LazyEnum();
		}
	}
	//对外暴露一个获取User对象的静态方法
	public static LazyEnum getInstance() {
		//从枚举对象中获取，实例化后的单例对象
		return SingletonEnum.INSTANCE.lazy;
	}
}
