package com.design.pattern.observer.mouse;

import com.design.pattern.observer.core.Event;

import java.lang.reflect.Method;

/**
 * @ClassName MouseTest
 * @Description 观察者模式，模拟鼠标响应事件
 * @Author Jacob
 * @Date 2020/4/15 22:09
 */
public class MouseTest {

	public static void main(String[] args) {
		try {
			/**
			 * 模拟鼠标响应事件
			 * 类似js中，经常看到
			 * var input = document.getElementById("username");
			 * input.addListener("onclick", function(){});//这种写法
			 * 对应的该输入框，当触发鼠标点击方法后，需要回调到定义的 function方法中
			 * 使用观察者模式模拟此场景
			 */
			//1、需要一个类似function的callback回调方法
			MouseCallback callback = new MouseCallback();
			//获取点击事件，需要定义（在此为获取点击对应的回调方法）
			Method clickMethod = MouseCallback.class.getMethod("onClick", Event.class);
			//获取鼠标移开事件
			Method upMethod = MouseCallback.class.getMethod("onUp", Event.class);
			//获取鼠标点击事件
			Method downMethod = MouseCallback.class.getMethod("onDown", Event.class);
			//获取鼠标滚动事件
			Method wheelMethod = MouseCallback.class.getMethod("onWheel", Event.class);
			//2、类似与addListener方法，将回调方法绑定到被观察者身上
			Mouse mouse = new Mouse();
			//注册点击事件监听
			mouse.addListener(MouseEventType.ON_CLICK, callback, clickMethod);
			//注册鼠标移开事件监听
			mouse.addListener(MouseEventType.ON_UP, callback, upMethod);
			//注册鼠标摁下事件监听
//			mouse.addListener(MouseEventType.ON_DOWN, callback, downMethod);
			//注册鼠标滚动事件监听
			mouse.addListener(MouseEventType.ON_WHEEL, callback, wheelMethod);
			//完成注册事件之后执行鼠标操作，当把其中一个监听注册注释掉之后，就会发现，鼠标只执行操作，并未触发回调事件
			System.out.println("========================");
			mouse.click();
			System.out.println("========================");
			mouse.up();
			System.out.println("========================");
			mouse.down();
			System.out.println("========================");
			mouse.wheel();
			System.out.println("========================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
