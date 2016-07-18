package rabbitmq;

import base.Base;
import cn.track.rabbitmq.*;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016.7.15.
 */
public class RabbitMQDemo extends Base {
	@Inject
	private MessageSender sender;

	@Test
	public void testSendMessage () {
		CommonMessage message = new CommonMessage ();
		message.setSource ("中文测试");
		JSONObject obj = new JSONObject ();
		obj.put ("test", "test json message");
		message.setMessage (obj);
		sender.setRoutingKey ("message.tonson");
		sender.sendDataToQueue (message);
	}
}
