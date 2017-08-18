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
	private long userId;

	@Test
	public void addUser(){
		userId = userService.addUser("lyp").getId();
	}

	@Test
	public void updateUser() {
		addUser();
		User user = userService.getUser (userId);
		user.setName ("李四");
		userService.updateUser (user);
	}
}
