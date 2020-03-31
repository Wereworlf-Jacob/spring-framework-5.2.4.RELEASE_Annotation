package com.design.pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName Hungry
 * @Description 饿汉单例模式
 * @Author Jacob
 * @Date 2020/3/27 20:59
 */
public class Hungry implements Serializable {

	private static final long serialVersionUID = -6112871971681011101L;

	//类的内容加载顺序
	//先静态，后动态
	//先属性，后方法
	//先上后下
	private static Hungry hungry = new Hungry();

	//构造方法私有化，只允许内部实例化
	//一般来说，都会设置构造方法为私有，防止有人通过new，破坏该模式
	private Hungry() {
	}

	public static Hungry getInstance() {
		return hungry;
	}

}
