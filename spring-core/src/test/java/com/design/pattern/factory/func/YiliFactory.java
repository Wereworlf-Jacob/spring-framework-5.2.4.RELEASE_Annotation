package com.design.pattern.factory.func;

import com.design.pattern.factory.Milk;
import com.design.pattern.factory.Yili;

/**
 * @ClassName YiliFactory
 * @Description 伊利牛奶生产工厂
 * @Author Jacob
 * @Date 2020/3/27 20:12
 */
public class YiliFactory implements Factory {

	@Override
	public Milk getMilk() {
		return new Yili();
	}

}
