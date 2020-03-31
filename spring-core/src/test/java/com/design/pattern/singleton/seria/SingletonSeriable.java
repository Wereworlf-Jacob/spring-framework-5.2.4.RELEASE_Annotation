package com.design.pattern.singleton.seria;

import java.io.Serializable;

/**
 * @ClassName SingletonSeriable
 * @Description 单例模式序列化操作
 * @Author Jacob
 * @Date 2020/3/31 15:46
 * @Version 1.0
 **/
public class SingletonSeriable implements Serializable {

	private static final long serialVersionUID = -5308553841285688166L;

	private static SingletonSeriable single = new SingletonSeriable();

	private SingletonSeriable() {
	}

	public static SingletonSeriable getInstance() {
		return single;
	}

	private Object readResolve(){
		return single;
	}

}
