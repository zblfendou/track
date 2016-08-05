package cn.track.service.task;

import cn.track.models.task.TimedTask;

/**
 * Created by Administrator on 2016.8.5.
 */
public interface QuartzUtils {
	void cancelTimedTaskSchedule (TimedTask job);

	void addTimedTaskSchedule (TimedTask job);
}
