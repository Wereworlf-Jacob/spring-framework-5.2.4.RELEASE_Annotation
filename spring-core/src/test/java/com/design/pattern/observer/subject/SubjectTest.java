package com.design.pattern.observer.subject;

import com.design.pattern.observer.core.Event;

import java.lang.reflect.Method;

/**
 * @ClassName SubjectTest
 * @Description 主题-观察者模式测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 15:42
 **/
public class SubjectTest {

	public static void main(String[] args) {

		//在使用过程中，我们创建一个主题
		Subject subject = new Subject();
		//这个主题，我们可以直接使用它的方法
//		subject.add();

		//当我们需要通知观察者，发送行为的时候
		//首先，我们需要把观察者搞出来
		Observer observer = new Observer();
		//获取要通知观察者要执行的方法
		Method method = null;
		try {
			method = Observer.class.getMethod("advice", Event.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		if (method == null) {
			System.out.println("oh shit! the observer don't have our method");
		}
		//然后给我们的被观察者，添加监听事件
		subject.addListener(SubjectEventType.ON_ADD, observer, method);

		//最后再执行被观察者的添加方法时，我们的观察者就能在添加方法之后第一时间，产生响应
		subject.add();

		/**
		 * 观察者模式：
		 * 适用于：发布-订阅，消息通知，邮件通知；场景的使用
		 * 此模式中需要具备：1、观察者；2、被观察者；3、监听器；4、事件的枚举类型
		 * 1、观察者与被观察者没有直接联系，被观察者可以选择不通知观察者
		 * 2、被观察者通过监听器，添加监听任务，来和观察者进行关系绑定
		 * 3、添加监听任务，需要区分事件类型，确定观察者对象，以及观察者需要响应的行为
		 * 4、被观察者，发生行为变化时，就要回调监听任务中绑定的被观察者的方法。
		 * 5、回调操作，应该由代理模式完成，被观察者只需要执行自己的方法，回调操作由代理类完成
		 */
	}

}
