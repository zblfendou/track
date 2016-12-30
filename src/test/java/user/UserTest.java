package user;

import base.Base;
import cn.track.models.user.User;
import cn.track.service.user.UserService;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.6.23.
 */
public class UserTest extends Base {
	@Inject
	private UserService userService;

	@Test
	public void addUser(){
		userService.addUser("lyp");
	}

	@Test
	public void updateUser() {
		User user = userService.getUser (1);
		user.setName ("李四");
		userService.updateUser (user);
	}
}
