package com.design.pattern.observer.subject;

import com.design.pattern.observer.core.EventListener;

/**
 * @ClassName Subject
 * @Description 主题类(这是一个被观察者，当发生行为操作时，需要通知观察者)，其包含有，添加和删除方法
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 15:43
 **/
//被观察者，应该继承时间监听器，用于被观察者在产生行为操作后，自行通知观察者
public class Subject extends EventListener {

	/**
	 * 被观察者，拥有的行为方式，
	 * 此处，应该使用动态代理模式，生成代理类，来执行触发方法（通知观察者，我行动了，你要跟着哦）
	 */
	public void add(){
		System.out.println("you go to add a new subject!");
		this.trigger(SubjectEventType.ON_ADD);
	}

	public void remove() {
		System.out.println("bad, I lost a subject~");
		this.trigger(SubjectEventType.ON_REMOVE);
	}

}
