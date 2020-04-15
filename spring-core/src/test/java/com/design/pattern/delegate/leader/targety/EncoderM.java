package com.design.pattern.delegate.leader.targety;

import com.design.pattern.delegate.leader.Member;

/**
 * @ClassName EncoderM
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 14:31
 **/
public class EncoderM implements Member {
	@Override
	public void doing() {
		System.out.println("I'm encoder, I will encode the msg");
	}
}
