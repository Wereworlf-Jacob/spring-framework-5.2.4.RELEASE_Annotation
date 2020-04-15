package com.design.pattern.observer.subject;

import com.design.pattern.observer.core.Event;

/**
 * @ClassName Observer
 * @Description 观察者，当被观察者有行动时，需要得到通知
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 15:46
 **/
public class Observer {

	//接收通知的方法应该接收一个事件对象，收到通知后去完成自己的任务
	//同时应该还要有一个监听器，来通知观察者
	public void advice(Event event){
		System.out.println("I will go to myself work!\n" + event);
	}

}
