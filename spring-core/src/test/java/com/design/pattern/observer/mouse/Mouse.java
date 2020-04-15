package com.design.pattern.observer.mouse;

import com.design.pattern.observer.core.EventListener;

/**
 * @ClassName Mouse
 * @Description 先有一个鼠标对象，被观察者
 * @Author Jacob
 * @Date 2020/4/15 22:01
 */
public class Mouse extends EventListener {

	/**
	 * 同样，此处回调方法的调用，依然需要采用代理模式实现比较合理
	 */
	public void click() {
		System.out.println("please click this button!");
		this.trigger(MouseEventType.ON_CLICK);
	}

	public void up() {
		System.out.println("oh,God! get out from my body");
		this.trigger(MouseEventType.ON_UP);
	}

	public void down() {
		System.out.println("I'll get down");
		this.trigger(MouseEventType.ON_DOWN);
	}

	public void wheel() {
		System.out.println("ache you are so stupid!");
		this.trigger(MouseEventType.ON_WHEEL);
	}

}
