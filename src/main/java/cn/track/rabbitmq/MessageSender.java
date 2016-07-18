package cn.track.rabbitmq;

/**
 * Created by Administrator on 2016.7.15.
 */

import org.springframework.amqp.core.AmqpTemplate;

public class MessageSender {

	private AmqpTemplate amqpTemplate;

	private String routingKey;

	public AmqpTemplate getAmqpTemplate () {
		return amqpTemplate;
	}

	public void setAmqpTemplate (AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public String getRoutingKey () {
		return routingKey;
	}

	public void setRoutingKey (String routingKey) {
		this.routingKey = routingKey;
	}

	public void sendDataToQueue (Object obj) {
		amqpTemplate.convertAndSend (this.routingKey, obj);
	}

}