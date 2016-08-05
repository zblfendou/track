package cn.track.models.task;

import javax.inject.Named;

/**
 * Created by Administrator on 2016.8.5.
 */
@Named ("taskExecuter")
public class TaskExecuter {
	public void executeTask (TimedTask timedTask) {
		if (timedTask instanceof TestTimeTask) {
			executeTask ((TestTimeTask) timedTask);
		}
	}

	public void executeTask (TestTimeTask task) {
		System.out.println ("TaskExecuter:doing that->" + task.getJobName () + "  " + task.getJobGroup ());
	}
}
