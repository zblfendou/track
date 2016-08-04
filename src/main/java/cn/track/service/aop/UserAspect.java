package cn.track.service.aop;

import org.aspectj.lang.annotation.*;

import javax.inject.Named;

/**
 * Created by Administrator on 2016.8.4.
 */
@Named
@Aspect
public class UserAspect {
	@Pointcut ("@annotation(cn.track.service.aop.EventCutPoint)")
	public void methodPointCut () {

	}

	// 在执行指定方法前执行
	@Before (value = "methodPointCut()")
	private void checkSecurity () {
		System.out.println ("添加前检查通过");
	}

	// 在执行指定方法后执行
	@After (value = "methodPointCut()")
	private void checkResult () {
		System.out.println ("添加后检查通过");
	}

	@Before ("execution(* cn.track.service.user.*.add*(..))")
	public void test () {
		System.out.println ("你妹");
	}
}
