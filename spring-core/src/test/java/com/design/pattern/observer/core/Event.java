package com.design.pattern.observer.core;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName Event
 * @Description 事件对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 16:04
 **/
public class Event {

	//事件源
	private Object source;
	//通知对象
	private Object target;
	//对象要执行的方法
	private Method method;
	//触发项
	private String trigger;
	//触发时间
	private Date time;

	public Event(Object target, Method method) {
		this.target = target;
		this.method = method;
	}

	public Object getSource() {
		return source;
	}

	public Object getTarget() {
		return target;
	}

	public Method getMethod() {
		return method;
	}

	public String getTrigger() {
		return trigger;
	}

	Event setSource(Object source) {
		this.source = source;
		return this;
	}

	Event setTrigger(String trigger) {
		this.trigger = trigger;
		return this;
	}

	@Override
	public String toString() {
		return "Event{" +
				"\n\tsource=" + source + "\n" +
				"\t, target=" + target + "\n" +
				"\t, method=" + method + "\n" +
				"\t, trigger=" + trigger + "\n" +
				"\t, time='" + time + '\'' + "\n" +
				'}';
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
