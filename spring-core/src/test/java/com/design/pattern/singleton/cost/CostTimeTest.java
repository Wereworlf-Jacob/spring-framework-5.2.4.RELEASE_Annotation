package com.design.pattern.singleton.cost;

import com.design.pattern.singleton.safe.SingletonFactory;

/**
 * @ClassName CostTimeTest
 * @Description
 * @Author Jacob
 * @Date 2020/3/31 13:26
 * @Version 1.0
 **/
public class CostTimeTest {

	private static int count = 200000000;

	private static SingletonFactory factory = new SingletonFactory();

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < count; i++) { //同步状态下，获取数据2亿次，耗时毫秒
//			factory.getHungry();      //饿汉方式-线程安全 用时：3 毫秒
//			factory.getDoubleCheck(); //懒汉-双重锁机制-线程相对安全 用时：107 毫秒
//			factory.getLazyEnum(); //懒汉-枚举方式-线程安全 用时：4 毫秒
//			factory.getStaticClassInner(); //懒汉-静态内部类方式-线程安全 用时：3 毫秒
//			factory.getSyncSafe(); //懒汉-同步锁方式-线程安全 用时：3442 毫秒 平均3.4秒
//			factory.getSyncUnsafe(); //懒汉-线程非安全 用时：3 毫秒

			//使用concurrentMap，用时：870毫秒 平均0.8秒 线程安全
			//使用Map，用时：1041毫秒 平均1秒 线程不安全
			factory.getRegister(); //懒汉-注册登记-线程安全（与登记容器相关）
		}
		long end = System.currentTimeMillis();
		System.out.println("total cost is " + (end - begin) + " milisecond ");
	}

}
