package com.design.pattern.singleton.safe;

/**
 * @ClassName AbstractFactory
 * @Description
 * @Author Jacob
 * @Date 2020/3/31 10:28
 * @Version 1.0
 **/
public abstract class AbstractFactory {

	public abstract Object getHungry();

	public abstract Object getDoubleCheck();

	public abstract Object getLazyEnum();

	public abstract Object getStaticClassInner();

	public abstract Object getSyncSafe();

	public abstract Object getSyncUnsafe();

	public abstract Object getRegister();

}
