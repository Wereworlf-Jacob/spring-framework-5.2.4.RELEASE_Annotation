package com.design.pattern.factory.func;

import com.design.pattern.factory.Mengniu;
import com.design.pattern.factory.Milk;

/**
 * @ClassName MengniuFactory
 * @Description 蒙牛牛奶生产工厂
 * @Author Jacob
 * @Date 2020/3/27 20:11
 */
public class MengniuFactory implements Factory {

	@Override
	public Milk getMilk() {
		return new Mengniu();
	}

}
