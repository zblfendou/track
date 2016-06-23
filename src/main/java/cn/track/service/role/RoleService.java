package cn.track.service.role;


import cn.track.models.role.Role;

import java.util.List;

/**
 * Created by Administrator on 2016.6.23.
 */
public interface RoleService {
	void addRole (Role role);

	void deleteRole (long id);

	void updateRole(Role role);

	Role getRole (long id);

	List<Role> getAllRole ();
}
