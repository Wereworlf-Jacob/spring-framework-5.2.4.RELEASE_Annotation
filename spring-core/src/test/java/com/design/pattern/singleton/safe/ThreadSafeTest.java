package com.design.pattern.singleton.safe;

import com.design.pattern.singleton.*;
import kotlin.Lazy;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ThreadSafeTest
 * @Description 线程安全性测试类
 * @Author Jacob
 * @Date 2020/3/30 11:50
 * @Version 1.0
 **/
public class ThreadSafeTest {

	static int threadNum = 10000;

	static CountDownLatch begin = new CountDownLatch(1);

	static CountDownLatch latch = new CountDownLatch(threadNum);

	static SingletonFactory factory = new SingletonFactory();

	public static void main(String[] args) {
		testThreadSalf();

	}

	public static void testThreadSalf(){
		for (int i = 0; i < threadNum; i++) {
			new Thread(new MyThread(begin, latch, factory)).start();
		}
		System.out.println("Every Thread Ready!");
		begin.countDown();
		Long beginTime = System.currentTimeMillis();
		System.out.println("GO!!!");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("All Thread finished, cost time: " + (endTime - beginTime) + " millisecond!");
	}

}
