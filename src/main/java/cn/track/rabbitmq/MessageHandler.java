package cn.track.rabbitmq;

/**
 * Created by Administrator on 2016.7.15.
 */

import org.apache.commons.logging.*;

public class MessageHandler {

	private Log log = LogFactory.getLog (getClass ());

	//	@Override
	public void handleMessage (CommonMessage message) {
		try {
			System.out.println ("...." + message);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

}