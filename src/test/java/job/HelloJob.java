package job;

import org.quartz.*;

/**
 * Created by Administrator on 2016.8.5.
 */
public class HelloJob implements Job {
	/**
	 * <p>
	 * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
	 * fires that is associated with the <code>Job</code>.
	 * </p>
	 * <p>
	 * <p>
	 * The implementation may wish to set a
	 * {@link JobExecutionContext#setResult(Object) result} object on the
	 * {@link JobExecutionContext} before this method exits.  The result itself
	 * is meaningless to Quartz, but may be informative to
	 * <code>{@link JobListener}s</code> or
	 * <code>{@link TriggerListener}s</code> that are watching the job's
	 * execution.
	 * </p>
	 * @param context
	 * @throws JobExecutionException
	 * 		if there is an exception while executing the job.
	 */
	@Override
	public void execute (JobExecutionContext context) throws JobExecutionException {
		System.out.println ("提交");
	}
}
