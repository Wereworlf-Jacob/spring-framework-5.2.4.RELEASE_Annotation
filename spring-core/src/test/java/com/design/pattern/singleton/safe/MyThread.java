package com.design.pattern.singleton.safe;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyThread
 * @Description 用来测试的线程类
 * @Author Jacob
 * @Date 2020/3/31 10:23
 * @Version 1.0
 **/
public class MyThread implements Runnable {

	//起跑计时器
	private CountDownLatch begin;

	//线程执行完成计时器
	private CountDownLatch pools;

	//工厂
	private SingletonFactory factory;

	public MyThread(CountDownLatch begin, CountDownLatch pools, SingletonFactory factory) {
		this.begin = begin;
		this.pools = pools;
		this.factory = factory;
	}

	@Override
	public void run() {
		try {
			begin.await(); //在喊开始之前，线程全部阻塞
			Object obj = null; //3W数据并发下，1次，2次，3次 耗时 * 毫秒
//			obj = factory.getHungry();      //饿汉方式-线程安全
//			obj = factory.getDoubleCheck(); //懒汉-双重锁机制-线程相对安全
//			obj = factory.getLazyEnum(); //懒汉-枚举方式-线程安全
//			obj = factory.getStaticClassInner(); //懒汉-静态内部类方式-线程安全
			obj = factory.getSyncSafe(); //懒汉-同步锁方式-线程安全
//			obj = factory.getSyncUnsafe(); //懒汉-线程非安全
//			obj = factory.getRegister(); //懒汉-注册登记-线程安全（与登记容器相关）
			System.out.println(obj); //测试接口耗时时，关闭此日志输出
			System.out.println(new Date());
			pools.countDown(); //每当一个线程跑完之后，线程池就记录一个线程完成
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
