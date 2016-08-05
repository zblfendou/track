package job;

import base.Base;
import cn.track.models.task.TestTimeTask;
import cn.track.service.task.QuartzUtilsImpl;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.*;

/**
 * Created by Administrator on 2016.8.5.
 */
public class QuartzTest extends Base {
	@Inject
	private QuartzUtilsImpl quartzUtils;

	public static void main (String[] args) {
		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler ();

			// and start it off
			scheduler.start ();
			System.out.println (scheduler.isStarted ());
			scheduler.shutdown ();

		} catch (SchedulerException se) {
			se.printStackTrace ();
		}
	}

	@Test
	public void testJob () {
		Calendar instance = Calendar.getInstance ();
		instance.add (Calendar.SECOND, 10);
		TestTimeTask testTimeTask = new TestTimeTask (new Date ());
		quartzUtils.addTimedTaskSchedule (testTimeTask);
	}
}
