package cn.track.service.role.impl;

import cn.track.models.role.Role;
import cn.track.repositories.role.RoleRepositories;
import cn.track.service.role.RoleService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.*;
import java.util.List;

/**
 * Created by Administrator on 2016.6.23.
 */
@Named
public class RoleServiceImpl implements RoleService {
	@Inject
	private RoleRepositories roleDao;

	@Override
	@Transactional
	public void addRole (Role role) {
		roleDao.save (role);
	}

	@Override
	@Transactional
	public void deleteRole (long id) {
		roleDao.delete (id);
	}

	@Override
	@Transactional
	public void updateRole (Role role) {
		roleDao.save (role);
	}

	@Override
	public Role getRole (long id) {
		return roleDao.findOne (id);
	}

	@Override
	public List<Role> getAllRole () {
		return roleDao.findAll ();
	}
}
