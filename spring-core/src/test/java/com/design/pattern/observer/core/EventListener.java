package com.design.pattern.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EventListener
 * @Description 事件监听器，用于观察到被观察者行为变化后，来通知观察者
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 16:11
 **/
public class EventListener {

	//监听器，应该有一个容器，来保存监听内容，应该使用枚举类型，来区分监听事件
	protected Map<Enum, Event> map = new HashMap<>();

	//添加监听事件，应该是添加一个该事件，对应回调观察者哪个方法的监听
	public void addListener(Enum eventType, Object target, Method callback){
		//把事件类型，对应响应事件，放到容器里面
		//需要通过反射，来调用观察者的方法
		map.put(eventType, new Event(target, callback));
	}

	//事件触发后，通知观察者，执行观察者的方法
	//call 事件触发类型
	protected void trigger(Enum call){
		if (!map.containsKey(call)) return;
		//从容器中获取到响应的事件信息，然后调用私有方法，执行响应操作
		this.trigger(map.get(call).setTrigger(call.toString()));
	}

	/**
	 * 私有方法，用于接收触发时间后，执行通知观察者的方法
	 * @param event
	 */
	private void trigger(Event event) {
		//给事件设置事件源和触发时间
		event.setSource(this);
		event.setTime(new Date());

		//触发了点击时间，通知观察者，执行对应的事件方法
		try {
			event.getMethod().invoke(event.getTarget(), event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
