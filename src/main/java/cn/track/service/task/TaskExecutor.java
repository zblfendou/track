package cn.track.service.task;

import cn.track.models.task.TestTimeTask;
import cn.track.models.task.TimedTask;
import cn.track.models.user.User;
import cn.track.service.user.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016.8.5.
 */
@Named ("quartz_taskExecutor")
public class TaskExecutor {
	@Inject
	private UserService userService;
	public void executeTask (TimedTask timedTask) {
		if (timedTask instanceof TestTimeTask) {
			executeTask ((TestTimeTask) timedTask);
		}
	}

	public void executeTask (TestTimeTask task) {
		List<User> allUser = userService.getAllUser ();
		System.out.println ("用户总数量:" + allUser.size ());
        System.out.println("TaskExecutor:doing->" + task.getJobName() + "  " + task.getJobGroup());
    }
}
