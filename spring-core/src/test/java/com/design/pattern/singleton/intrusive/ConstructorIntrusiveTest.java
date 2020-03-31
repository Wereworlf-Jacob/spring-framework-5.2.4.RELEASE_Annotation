package com.design.pattern.singleton.intrusive;

import com.design.pattern.singleton.Hungry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName ConstructorIntrusiveTest
 * @Description
 * @Author Jacob
 * @Date 2020/3/31 13:58
 * @Version 1.0
 **/
public class ConstructorIntrusiveTest {

	public static void main(String[] args) {

		//通过反射创建一个单例对象
		Object obj = initByConstructor(Hungry.class);
		Object objSingleton = Hungry.getInstance();
		System.out.println(obj);
		System.out.println(objSingleton);
		//通过对比发现两个对象地址不一样，就是说，通过入侵式编程能够破坏对象的单例
		System.out.println(obj == objSingleton);

		//再次通过反射调用，发现已无法创建对象，会抛出异常信息
		Object object = initByConstructor(SingletonConstuctors.class);
		System.out.println(object);
	}

	public static Object initByConstructor(Class clazz){
		Constructor[] constructors = clazz.getDeclaredConstructors();
		Object obj = null;
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			System.out.println("parameters num : " + constructor.getParameterCount());
			try {
				if (constructor.getParameterCount() == 0) {
					obj = constructor.newInstance();
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

}
