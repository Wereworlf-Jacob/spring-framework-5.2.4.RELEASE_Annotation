package com.design.pattern.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName SameCityProxy
 * @Description 同城代理服务
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 10:21
 **/
public class SameCityProxy implements MethodInterceptor {

	public Object getInstance(Class<?> clazz){
		//创建一个cglib的增强类，该类用于创建动态类
		Enhancer enhancer = new Enhancer();
		//设置被代理类的信息
		enhancer.setSuperclass(clazz);
		//设置回调方法，在这使用当前类作为回调方法
		enhancer.setCallback(this);
		//通过增强类，创建一个代理对象，并返回
		return enhancer.create();
	}

	/**
	 * cglib动态代理，必须满足以下条件
	 * 1、代理类，必须实现MethodInterceptor接口
	 * 实现原理：
	 * cglib应用了六项开发原则之一的，里氏代换原则：父类能干的事，子类都能代理来完成
	 * cglib使用asm字节码操作和分析的框架，来创建给代理类
	 * 代理类，继承了被代理对象的类信息，所以使用cglib不需要被代理对象拥有顶层接口
	 * 代理类包含一个Method信息，和一个MethodProxy信息
	 * 其中Method信息，就是通过字节码重组后，代理类重写父类的方法
	 * 在该方法中，会获取一个MethodInterceptor，如果获取到interceptor，那么就会调用
	 * interceptor的intercept方法，回调到代理类的代理方法中，在代理方法中在通过反射，来调用被代理类的方法
	 * 否则，直接执行父类的方法，所以代理类需要实现MethodInterceptor接口，来接收被代理对象的回调行为
	 * 如此才能实现代理行为，否则无法代理被代理对象的行为
	 * 其次，代理类包含一个MethodProxy信息，该信息通过Method.creat创建的一个被代理对象要执行方法的代理方法
	 * 比如findLove的代理方法，代理类，在执行代理行为后，通过该代理方法，来实际调用被代理对象的行为
	 * 所以，在执行完代理行为后，要执行被代理对象的行为时，要通过methodProxy.invokeSuper，来实际执行被代理对象的方法
	 * 注意：
	 * 1、不能使用method方法，因为method方法就等于是代理类的findLove方法，
	 *    如果在代理类调用findLove的时候，在interceptor代理行为中，
	 *    仍然通过method来执行代理类的findLove方法，那么就造成了死循环，会直接oom
	 * 2、methodProxy要执行invokeSupper方法，来实际调用到被代理对象行为
	 *    methodProxy中含有两个method信息，一个是invoke代表findLove方法，一个是invokeSuper代表CGLIB$findLove$0方法
	 *    findLove方法与method意义相同，而CGLIB$findLove$0方法才真正调用了super.findLove()；
	 *    所以如果使用methodProxy.invoke，同样会因为一直死循环调用代理类的findLove方法，而造成oom
	 * @param obj
	 * @param method
	 * @param args
	 * @param methodProxy
	 * @return {@link Object}
	 * @throws
	 *
	 * @author Jacob
	 * @since 2020/4/13
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		//回调到的代理行为
		System.out.println("We receive you conditions");
		//通过方法代理反射调用，被代理对象的方法
		Object result = methodProxy.invokeSuper(obj, args);
		System.out.println("congratulations!");
		return result;
	}
}
