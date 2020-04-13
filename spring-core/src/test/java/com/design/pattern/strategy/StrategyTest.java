package com.design.pattern.strategy;

import com.design.pattern.strategy.payport.AliPay;
import com.design.pattern.strategy.payport.PayType;

/**
 * @ClassName StrategyTest
 * @Description 策略模式应用场景测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:16
 **/
public class StrategyTest {

	public static void main(String[] args) {
		OrderInfo orderInfo = new OrderInfo("zs", "202001031523001000009", 342.58);
		//如下，这样就应用了策略模式，每种支付方式算法，都试一个不同的payment，客户只需要传一个payment就可以了，而不需要了解payment的具体算法
		//但是这样仍然需要客户去创建payment，所以该内容可以使用enum继续优化
		System.out.println(orderInfo.pay(new AliPay()));
		//使用enum，orderInfo的pay方法参数就不是payment了，而是enum的payType
		System.out.println(orderInfo.pay(PayType.UNION));//这样直接传入一个payType，省去了if/else 和 switch操作
		//给enum增加code属性，还可以根据code来匹配支付方式
		System.out.println(orderInfo.pay("wechat"));
	}

}
