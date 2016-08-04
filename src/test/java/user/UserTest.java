package user;

import base.Base;
import cn.track.models.user.User;
import cn.track.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.6.23.
 */
public class UserTest extends Base {
	@Inject
	private UserService userService;

	public static void main (String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext ("application-context.xml");
		UserService userService = (UserService) context.getBean ("userService");
		cn.track.models.user.User user = new cn.track.models.user.User ();
		user.setName ("lyp");
		user.setPwd ("1234");
		userService.addUser (user);
	}

	@Test
	public void addUser(){
		cn.track.models.user.User user = new cn.track.models.user.User ();
		user.setName ("lyp");
		user.setPwd ("1234");
		userService.addUser (user);
	}

	@Test
	public void updateUser() {
		User user = userService.getUser (1);
		user.setName ("李四");
		userService.updateUser (user);
	}
}
