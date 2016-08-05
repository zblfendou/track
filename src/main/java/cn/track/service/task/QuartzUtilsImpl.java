package cn.track.service.task;

import cn.track.models.task.*;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.inject.*;

/**
 * Created by Administrator on 2016.8.5.
 */
@Named ("quartzUtils")
public class QuartzUtilsImpl implements QuartzUtils, InitializingBean {
	@Inject
	private SchedulerFactory schedulerFactory;

	/**
	 * Invoked by a BeanFactory after it has set all bean properties supplied
	 * (and satisfied BeanFactoryAware and ApplicationContextAware).
	 * <p>This method allows the bean instance to perform initialization only
	 * possible when all bean properties have been set and to throw an
	 * exception in the event of misconfiguration.
	 * @throws Exception
	 * 		in the event of misconfiguration (such
	 * 		as failure to set an essential property) or if initialization fails.
	 */
	@Override
	public void afterPropertiesSet () throws Exception {
		System.out.println ("初始化完成后打印出来的");
	}

	@Override
	public void cancelTimedTaskSchedule (TimedTask job) {

	}

	@Override
	public void addTimedTaskSchedule (TimedTask job) {
		try {
			Scheduler scheduler = new StdSchedulerFactory ().getScheduler ();
			TriggerKey triggerKey = TriggerKey.triggerKey (job.getJobName (), job.getJobGroup ());
			Trigger trigger = scheduler.getTrigger (triggerKey);
			// 不存在，创建一个
			if (null == trigger) {
				JobDetail jobDetail = JobBuilder.newJob (TimedTaskExecuteImpl.class).withIdentity (job.getJobName (),
						job.getJobGroup ()).build ();
				jobDetail.getJobDataMap ().put ("scheduleJob", job);
				// 按新的表达式构建一个新的trigger
				trigger = TriggerBuilder.newTrigger ().withIdentity (job.getJobName (), job.getJobGroup ()).startAt (job.getStartTime ()).build ();
				scheduler.scheduleJob (jobDetail, trigger);
			} else {
				// trigger已存在，则更新相应的定时设置
				trigger = trigger.getTriggerBuilder ().withIdentity (triggerKey)
						.startAt (job.getStartTime ()).build ();
				// 按新的trigger重新设置job执行
				scheduler.rescheduleJob (triggerKey, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace ();
		}

	}

	@DisallowConcurrentExecution
	private class TimedTaskExecuteImpl implements Job {

		@Override
		public void execute (JobExecutionContext context) throws JobExecutionException {
			System.out.println (context.getJobDetail ().getKey ());
			System.out.println ("TimedTaskExecuteImpl->打印出点啥就行");
			try {
				SchedulerContext schedulerContext = context.getScheduler ().getContext ();
				TaskExecuter executer = (TaskExecuter) schedulerContext.get ("taskExecuter");
				TimedTask scheduleJob = (TimedTask) context.getMergedJobDataMap ().get ("scheduleJob");
				executer.executeTask (scheduleJob);
			} catch (SchedulerException e) {
				e.printStackTrace ();
			}
		}
	}
}
