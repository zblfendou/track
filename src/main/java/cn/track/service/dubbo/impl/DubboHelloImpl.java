package cn.track.service.dubbo.impl;

import cn.track.service.dubbo.DubboHello;

import javax.inject.Named;

/**
 * Created by Administrator on 2016.6.27.
 */
@Named ("dubboHello")
public class DubboHelloImpl implements DubboHello {
	public static void main (String[] args) {
		System.out.println ("test");
	}

	@Override
	public String sayHello (String str) {
		System.out.println (str);
		return "dubbo test is ok";
	}
}
