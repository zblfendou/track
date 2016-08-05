package cn.track.models.task;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016.8.5.
 */
public abstract class TimedTask implements Serializable {
	private Date startTime;

	public abstract String getJobName ();

	public abstract String getJobGroup ();

	public Date getStartTime () {
		return startTime;
	}

	public void setStartTime (Date startTime) {
		this.startTime = startTime;
	}
}
