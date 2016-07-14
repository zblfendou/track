package role;

import base.Base;
import cn.track.models.role.Role;
import cn.track.service.role.RoleService;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by love-jia on 2016/6/23.
 */
public class RoleTest extends Base {
    @Inject
    private RoleService roleService;

    @Test
    public void addRole() {
        Role role = new Role();
        role.setName("超级管理员");
        roleService.addRole(role);

    }
}
