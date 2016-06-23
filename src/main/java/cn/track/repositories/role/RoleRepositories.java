package cn.track.repositories.role;


import cn.track.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.6.23.
 */
public interface RoleRepositories extends JpaRepository<Role, Long> {
}
