package com.design.pattern.factory;

/**
 * @ClassName Telunsu
 * @Description 特仑苏属于牛奶的一个品牌，所以要实现牛奶的接口
 * @Author Jacob
 * @Date 2020/3/27 19:30
 */
public class Telunsu implements Milk {

	@Override
	public String getName() {
		return "te lun su";
	}

}
