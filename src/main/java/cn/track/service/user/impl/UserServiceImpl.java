package cn.track.service.user.impl;

import cn.track.models.user.User;
import cn.track.repositories.user.UserRepository;
import cn.track.service.aop.EventCutPoint;
import cn.track.service.user.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.*;
import java.util.List;

/**
 * Created by Administrator on 2016.6.23.
 */
@Named ("userService")
public class UserServiceImpl implements UserService {
	@Inject
	private UserRepository userDao;

	@Override
	@Transactional
	@EventCutPoint
	public void addUser (User user) {
		userDao.save (user);
	}

	@Override
	@Transactional
	public void deleteUser (long id) {
		userDao.delete (id);
	}

	@Override
	@Transactional
	public void updateUser (User user) {
		userDao.save (user);
	}

	@Override
	public User getUser (long id) {
	return userDao.findOne (id);
	}

	@Override
	public List<User> getAllUser () {
		return userDao.findAll ();
	}
}
