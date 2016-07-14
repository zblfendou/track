package cn.track.service.dubbo.impl;

import cn.track.models.user.User;
import cn.track.service.dubbo.DubboHello;
import cn.track.service.user.UserService;

import javax.inject.*;

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
			User user = new User (name, pwd);
			userService.addUser (user);
		} catch (Exception e) {
			e.printStackTrace ();
			return false;
		}
		return true;
	}
}
