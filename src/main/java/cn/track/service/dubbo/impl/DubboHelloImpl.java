package cn.track.service.dubbo.impl;

import cn.track.service.dubbo.DubboHello;
import cn.track.service.user.UserService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016.6.27.
 */
@Named ("dubboHello")
public class DubboHelloImpl implements DubboHello {
	@Inject
	private UserService userService;

	@Override
	public String sayHello (String str) {

		return "dubbo test is ok";
	}

	@Override
	public boolean saveUser (String name, String pwd) {
		try {
			userService.addUser(name, pwd);
		} catch (Exception e) {
			e.printStackTrace ();
			return false;
		}
		return true;
	}
}
