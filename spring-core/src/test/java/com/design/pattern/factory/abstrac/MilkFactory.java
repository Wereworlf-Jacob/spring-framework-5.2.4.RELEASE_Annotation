package com.design.pattern.factory.abstrac;

import com.design.pattern.factory.Mengniu;
import com.design.pattern.factory.Milk;
import com.design.pattern.factory.Telunsu;
import com.design.pattern.factory.Yili;

/**
 * @ClassName
 * @Description
 * @Author Jacob
 * @Date 2020/3/27 20:30
 */
public class MilkFactory extends AbstractFactory {

	@Override
	public Milk getMengniu() {
		return new Mengniu();
	}

	@Override
	public Milk getYili() {
		return new Yili();
	}

	@Override
	public Milk getTelunsu() {
		return new Telunsu();
	}
}
