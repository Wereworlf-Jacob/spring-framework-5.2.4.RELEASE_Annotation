package com.design.pattern.singleton.safe;

import com.design.pattern.singleton.*;

/**
 * @ClassName SingletonFactory
 * @Description
 * @Author Jacob
 * @Date 2020/3/31 10:31
 * @Version 1.0
 **/
public class SingletonFactory extends AbstractFactory {
	@Override
	public Object getHungry() {
		return Hungry.getInstance();
	}

	@Override
	public Object getDoubleCheck() {
		return LazyDoubleCheck.getInstance();
	}

	@Override
	public Object getLazyEnum() {
		return LazyEnum.getInstance();
	}

	@Override
	public Object getStaticClassInner() {
		return LazyStaticInnerClass.getInstance();
	}

	@Override
	public Object getSyncSafe() {
		return LazyThreadSalfSync.getInstance();
	}

	@Override
	public Object getSyncUnsafe() {
		return LazyThreadUnsale.getInstance();
	}

	@Override
	public Object getRegister() {
		return LazyRegister.getInstance();
	}
}
