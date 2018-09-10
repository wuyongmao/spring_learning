package com.lin.consumer;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
 
/**
 * 消费接收
 * @author yongmao.wu
 * @since  2018年7月12日
 */
public class MessageConsumer implements MessageListener {
	
	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
 
	@Override
	public void onMessage(Message message) {
		logger.info("receive message:{}",message);
	}
 
}