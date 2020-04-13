package com.design.pattern.proxy.dynamic.jdk;

import com.design.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MeipoProxy
 * @Description 媒婆代理，用来给所有人代理找对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 10:01
 **/
public class MeipoProxy implements InvocationHandler {

	//代理类需要持有被代理的对象地址，这样完成代理任务后，及时通知被代理人
	private Person target;

	//获取代理类，代理人需要根据具体不同的人，来生成一个代理服务
	public Object getInstance(Person target){
		this.target = target;
		//代理类，需要实现invocationHandle接口，用于构造代理行为
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
	}

	/**
	 * jdk动态代理，必须满足以下条件
	 * 1、被代理对象，必须要有顶层接口
	 * 2、代理类，必须要实现invocationHandler接口
	 * 实现原理：
	 * jdk动态代理，通过字节码重组技术，创建一个新的代理类$proxy$number (number是通过自增属性自动上涨的，比如第一个为$proxy$0)
	 * $proxy$number，实现了被代理对象Zhangsan的所有顶层接口比如Person。所以被代理对象必须要有顶层接口才可以使用该方法
	 * 同时该代理类，实现了顶层接口的所有方法，并通过handler，调用到代理行为
	 * $proxy$number，持有一个handler对象，当代理类调用findLove方法是，实际调用是调用到handler的invoke方法
	 * 同时将要执行的findLove方法，告诉handler对象，然后在通过反射，来实际执行被代理对象的行为
	 * 所以，代理类需要实现invocationHandler接口，同时重写invoke方法，来构造代理行为
	 * @param proxy 动态生成的代理类$proxy$number
	 * @param method 要代理的方法，比如findLove
	 * @param args 执行方法包含的参数，比如findLove的args=null
	 * @return {@link Object} 代理对象方法的返回值，可以用来观察代理方法执行结果，用于后置处理
	 * @throws
	 *
	 * @author Jacob
	 * @since 2020/4/13
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * proxy:
		 */
		//构造代理行为
		System.out.println("begin match you conditions girl");
		Object o = method.invoke(this.target, args);
		System.out.println("congratulations!");
		return o;
	}
}
