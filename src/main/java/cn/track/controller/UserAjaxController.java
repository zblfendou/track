package cn.track.controller;

import cn.track.models.task.TestTimeTask;
import cn.track.service.task.QuartzUtils;
import cn.track.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Calendar;

/**
 * Created by Administrator on 2016.6.23.
 */
@Controller
public class UserAjaxController {
	@Inject
	private QuartzUtils quartzUtils;
    @Inject
    private UserService userService;

	@RequestMapping ("/test.do")
	public ModelAndView test (@RequestParam ("name") String name) {
        System.out.println("测试定时任务和切片" + name);
        Calendar instance = Calendar.getInstance ();
		instance.add (Calendar.SECOND, 10);
		TestTimeTask testTimeTask = new TestTimeTask (instance.getTime ());
		quartzUtils.addTimedTaskSchedule (testTimeTask);
        userService.addUser(name);
        return new ModelAndView ("aaa");
	}
}

