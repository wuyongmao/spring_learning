package com.wym.producer;
 
import java.io.IOException;
import java.io.Serializable;
 

import org.apache.commons.lang.SerializationUtils;
 

import com.wym.EndPoint;
 
 
/**
 * 功能概要：消息生产者
 * @author yongmao.wu
 * @since  2018年7月12日
 */
public class Producer extends EndPoint{
     
    public Producer(String endPointName) throws IOException{
        super(endPointName);
    }
 
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }  
}