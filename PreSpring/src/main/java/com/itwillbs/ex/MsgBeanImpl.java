package com.itwillbs.ex;

public class MsgBeanImpl implements MsgBean {

	@Override
	public /* abstract */ void sayHello(String name) {
		System.out.println("안녕!, " + name);
		
	}

}
