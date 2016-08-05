package cn.track.models.task;

import java.util.Date;

/**
 * Created by Administrator on 2016.8.5.
 */
public class TestTimeTask extends TimedTask {
	public TestTimeTask (Date startTime) {
		this.setStartTime (startTime);
	}

	@Override
	public String getJobName () {
		return "JOBNAMETEST1";
	}

	@Override
	public String getJobGroup () {
		return "GROUPTEST1";
	}
}
