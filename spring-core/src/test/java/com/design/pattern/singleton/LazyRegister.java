package com.design.pattern.singleton;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName LazyRegister
 * @Description 懒汉-单例模式-注册登记方式
 * @Author Jacob
 * @Date 2020/3/30 12:09
 * @Version 1.0
 **/
public class LazyRegister {

	//构造方法私有化
	private LazyRegister() {
	}

	//容器用于存放注册进来的单例类
	private static Map<String, LazyRegister> map = new HashMap<>(); //非线程安全
//	private static Map<String, LazyRegister> map = new ConcurrentHashMap<>(); //线程安全

	public static LazyRegister getInstance() {
		return getInstance(null);
	}

	public static LazyRegister getInstance(String name) {
		if (StringUtils.isEmpty(name)) {
			name = LazyRegister.class.getName();
		}
		if (!map.containsKey(name)) {
			map.put(name, new LazyRegister()); //线程不安全
//			map.putIfAbsent(name, new LazyRegister()); //线程安全
		}
		return map.get(name);
	}
}
