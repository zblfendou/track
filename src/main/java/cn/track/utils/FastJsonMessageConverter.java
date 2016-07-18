package cn.track.utils;

import cn.track.rabbitmq.CommonMessage;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016.7.15.
 */
public class FastJsonMessageConverter extends AbstractMessageConverter {

	public static final String DEFAULT_CHARSET = "UTF-8";
	@SuppressWarnings ("unused")
	private static Log log = LogFactory.getLog (FastJsonMessageConverter.class);
	private volatile String defaultCharset = DEFAULT_CHARSET;

	public FastJsonMessageConverter () {
		super ();
	}

	public void setDefaultCharset (String defaultCharset) {
		this.defaultCharset = (defaultCharset != null) ? defaultCharset
				: DEFAULT_CHARSET;
	}

	public Object fromMessage (Message message)
			throws MessageConversionException {
		Object o = new CommonMessage ();
		try {
			o = fromMessage (message, new CommonMessage ());
		} catch (Exception e) {
			log.error ("queue message error : " + message);
			e.printStackTrace ();
		}
		return o;
	}

	@SuppressWarnings ("unchecked")
	public <T> T fromMessage (Message message, T t) {
		String json = "";
		try {
			json = new String (message.getBody (), defaultCharset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace ();
		}
		return (T) JSONObject.parseObject (json, t.getClass ());
	}

	protected Message createMessage (Object objectToConvert,
	                                 MessageProperties messageProperties)
			throws MessageConversionException {
		byte[] bytes = null;
		try {
			String jsonString = JSONObject.toJSONString (objectToConvert);
			bytes = jsonString.getBytes (this.defaultCharset);
		} catch (UnsupportedEncodingException e) {
			throw new MessageConversionException (
					"Failed to convert Message content", e);
		}
		messageProperties.setContentType (MessageProperties.CONTENT_TYPE_JSON);
		messageProperties.setContentEncoding (this.defaultCharset);
		if (bytes != null) {
			messageProperties.setContentLength (bytes.length);
		}
		return new Message (bytes, messageProperties);

	}
}