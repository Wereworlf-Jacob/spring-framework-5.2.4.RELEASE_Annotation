package com.design.pattern.observer.mouse;

import com.design.pattern.observer.core.Event;

/**
 * @ClassName MouseCallback
 * @Description 要有一个鼠标触发之后的回调事件，观察者，响应被观察者的对应行为
 * @Author Jacob
 * @Date 2020/4/15 22:03
 */
public class MouseCallback {

	/**
	 * 对应鼠标触发事件，设定回调方法
	 */

	public void onClick(Event event) {
		System.out.println("on mouse click! event = " + event);
	}

	public void onUp(Event event) {
		System.out.println("on mouse up! event = " + event);
	}

	public void onDown(Event event) {
		System.out.println("on mouse down! event = " + event);
	}

	public void onWheel(Event event) {
		System.out.println("on mouse wheel! event = " + event);
	}

}
