package com.design.pattern.delegate.leader.targety;

import com.design.pattern.delegate.leader.Member;

/**
 * @ClassName DecoderM
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 14:32
 **/
public class DecoderM implements Member {
	@Override
	public void doing() {
		System.out.println("I'm decoder, I will decode the msg!");
	}
}
