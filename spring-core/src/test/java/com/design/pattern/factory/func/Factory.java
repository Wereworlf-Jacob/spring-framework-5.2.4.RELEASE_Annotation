package com.design.pattern.factory.func;

import com.design.pattern.factory.Milk;

/**
 * @ClassName Factory
 * @Description 这是一个工厂范本
 * @Author Jacob
 * @Date 2020/3/27 20:06
 */

/**
 * 1、工厂方法模式，隐藏生产过程，但是需要配置产品与流水线的对应关系
 * 配置错误，会导致用户选择产品A结果生产了产品B
 * 2、当需要扩展时，只需要增加一个新产品工厂的流水线，然后配置产品与流水线的关系
 * 所以此模式适用于生产较多类型产品，同时扩展性比较强的产品
 */
public interface Factory {

	//这个工厂指定可以生产牛奶
	Milk getMilk();

}
