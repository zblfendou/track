package cn.track.controller;

import cn.track.models.task.TestTimeTask;
import cn.track.service.task.QuartzUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

	@RequestMapping ("/test.do")
	public ModelAndView test (@RequestParam ("name") String name) {
		System.out.println ("测试成功" + name);
		Calendar instance = Calendar.getInstance ();
		instance.add (Calendar.SECOND, 10);
		TestTimeTask testTimeTask = new TestTimeTask (instance.getTime ());
		quartzUtils.addTimedTaskSchedule (testTimeTask);
		return new ModelAndView ("aaa");
	}
}

