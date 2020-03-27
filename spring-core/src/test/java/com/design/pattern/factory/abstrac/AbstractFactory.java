package com.design.pattern.factory.abstrac;

import com.design.pattern.factory.Milk;

/**
 * @ClassName AbstractFactory
 * @Description 抽象工厂
 * @Author Jacob
 * @Date 2020/3/27 20:25
 */
//通过这个工厂就可以知道，它能生产哪些产品
/**
 * 1、抽象工厂模式，隐藏生产过程，同时即时提供可生产的产品信息
 * 这样用户就从一个指定产品，变为选择产品，减少了出错率
 * 2、当需要扩展时，需要抽象工厂增加一个新产品的生产线
 * 同时具象工厂，增加该生产线的生产过程，之后用户就能即使看到你扩展的这个API
 * 不需要再刻意通知用户该产品已可以生产，所以该模式被广泛应用
 */
public abstract class AbstractFactory {

	//因为这是一个抽象类，所以它可以完成一些前置条件的逻辑
	//必须要申请成为一个工厂，要拿到营业执照，等等公用逻辑

	/**
	 *
	 * 可以在这一块进行处理，同时不暴露给用户
	 */

	public abstract Milk getMengniu();

	public abstract Milk getYili();

	public abstract Milk getTelunsu();

}
