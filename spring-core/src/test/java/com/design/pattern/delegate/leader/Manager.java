package com.design.pattern.delegate.leader;

import com.design.pattern.delegate.leader.targety.DecoderM;
import com.design.pattern.delegate.leader.targety.EncoderM;

/**
 * @ClassName Manager
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 14:29
 **/
public class Manager {

	public void recived(String command){
		if ("encode".equals(command))
			new EncoderM().doing();
		else if ("decode".equals(command)) {
			new DecoderM().doing();
		}
	}

}
