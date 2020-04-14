package com.design.pattern.delegate.mvc;

import com.design.pattern.delegate.mvc.controller.OrderController;
import com.design.pattern.delegate.mvc.controller.SystemController;
import com.design.pattern.delegate.mvc.controller.UserController;
import com.design.pattern.delegate.mvc.http.HttpServletRequest;
import com.design.pattern.delegate.mvc.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ServletDispatcher
 * @Description 在boss-manager-employee中相当于manager的角色
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 13:19
 **/
public class ServletDispatcher {

	private static Map<String, MappedHandler> map = new HashMap<>();//此处不考虑线程安全问题

	//代码块来模拟，在委托人向下分发任务之前，已经完成了任务与被委派人之前的关系绑定
	//此处，可以通过策略模式来实现，在spring中，通过注解的方法，来设置url与被委派人之间的关系
	//由此，可以通过url来确定，该任务由谁来完成
	//该步骤在构造方法之前执行，在静态代码块后执行
	{
		try {
			MappedHandler handler = new MappedHandler();
			String url;
			Class clazz;

			handler = new MappedHandler();
			url = "order/get";
			handler.setUrl(url);
			clazz = OrderController.class;
			handler.setController(clazz.newInstance());
			handler.setMethod(clazz.getMethod("getOrder", (Class<?>[]) null));
			map.put(url, handler);

			handler = new MappedHandler();
			url = "sys/get";
			handler.setUrl(url);
			clazz = SystemController.class;
			handler.setController(clazz.newInstance());
			handler.setMethod(clazz.getMethod("getConfiguration", (Class<?>[]) null));
			map.put(url, handler);

			handler = new MappedHandler();
			url = "user/add";
			handler.setUrl(url);
			clazz = UserController.class;
			handler.setController(clazz.newInstance());
			handler.setMethod(clazz.getMethod("addUser", (Class<?>[]) null));
			map.put(url, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//请求接收接口，用于委托人进行处理转发这些请求任务
	public void doService(HttpServletRequest request, HttpServletResponse response){
		doDispatcher(request, response);
	}

	private void doDispatcher(HttpServletRequest request, HttpServletResponse response) {
		//获取用户请求的url
		String url = request.getRequestUri();
		/**
		 * 在J2EE标准下，如果客户要发送一个请求，那么需要用户去xml进行配置servlet
		 * <sevlet>
		 *     //servlet的内部名称，自定义
		 *     <servlet-name>DemoAction</servlet-name>
		 *     //servlet的类全名：包名+类名
		 *     <servlet-class>com.uplooking.controller.DemoAction</servlet-class>
		 * </sevlet>
		 * //servlet的映射配置
		 * <servlet-mapping>
		 *     //servlet的内部名称，一定要和上面的内部名称保持一致
		 *     <servlet-name>DemoAction</servlet-name>
		 *     //servlet的映射路径（访问serclet的名称
		 *     <url-pattern>/demoAction.do</url-pattern>
		 * </servlet-mapping>
		 * //这种情况下，每当增加一个请求时就需要客户在xml中对应配置一个映射关系
		 * //使用委派模式，可以由委托人来进行任务调度，客户只需要发送一个请求命令，自然有委托人来进行调度并返回结果
		 */
		//根据用户请求，去找到这个url对应的某一个java类的方法（相当于employee，来执行任务）
		MappedHandler handler = map.get(url);
		//下发执行任务，并记录执行结果
		Object o = null;
		try {
			//将任务分发给method（通过反射调用其对应的方法）
			o = handler.getMethod().invoke(handler.getController(), null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//上报任务结果给boss
		response.setResult(o);
	}

	//任务调度句柄，用于保存url对应的class对象，以及要执行的method方法
	private class MappedHandler {

		private String url;

		private Object controller;

		private Method method;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Object getController() {
			return controller;
		}

		public void setController(Object controller) {
			this.controller = controller;
		}

		public Method getMethod() {
			return method;
		}

		public void setMethod(Method method) {
			this.method = method;
		}
	}

}
