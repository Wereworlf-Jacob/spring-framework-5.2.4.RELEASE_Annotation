package com.design.pattern.factory.func;

import com.design.pattern.factory.Milk;
import com.design.pattern.factory.Telunsu;

/**
 * @ClassName TelunsuFactory
 * @Description 特仑苏牛奶生产工厂
 * @Author Jacob
 * @Date 2020/3/27 20:13
 */
public class TelunsuFactory implements Factory {

	@Override
	public Milk getMilk() {
		return new Telunsu();
	}

}
