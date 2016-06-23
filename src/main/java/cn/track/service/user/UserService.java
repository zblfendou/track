package cn.track.service.user;

import cn.track.models.user.User;

import java.util.List;

/**
 * Created by Administrator on 2016.6.23.
 */
public interface UserService {
	void addUser (User user);

	void deleteUser (long id);

	void updateUser (User user);

	User getUser (long id);

	List<User> getAllUser ();
}
