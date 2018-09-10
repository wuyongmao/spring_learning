package com.wym.test;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 


import com.wym.consumer.QueueConsumer;
import com.wym.producer.Producer;
 
public class Test {
    public Test() throws Exception{
         
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        System.out.println("consumerThread.start()---------");

        consumerThread.start();
         
        Producer producer = new Producer("queue");
         
        for (int i = 0; i < 10; i++) {
            HashMap message = new HashMap();
            message.put("message number", i+"--lala");
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Test();
    }
}