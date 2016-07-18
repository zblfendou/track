package cn.track.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016.6.23.
 */
@Controller
public class UserAjaxController {

	@RequestMapping ("/test.do")
	public ModelAndView test (@RequestParam ("name") String name) {
		System.out.println ("测试成功" + name);
		return new ModelAndView ("aaa");
	}
}

