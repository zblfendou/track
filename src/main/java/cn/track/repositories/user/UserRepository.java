package cn.track.repositories.user;

import cn.track.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016.6.23.
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
