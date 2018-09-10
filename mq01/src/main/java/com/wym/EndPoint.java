package com.wym;
 
import java.io.IOException;
 
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
/**
 * 队列
 * @author yongmao.wu
 *
 */
public abstract class EndPoint{
     
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;
     
    public EndPoint(String endpointName) throws IOException{
         this.endPointName = endpointName;
         
         //Create a connection factory
         ConnectionFactory factory = new ConnectionFactory();
         
         //hostname of your rabbitmq server
         factory.setHost("127.0.0.1");
         factory.setPort(5672);
         factory.setUsername("admin");
         factory.setPassword("root");
         
         //getting a connection
         connection = factory.newConnection();
         
         //creating a channel
         channel = connection.createChannel();
         
         //declaring a queue for this channel. If queue does not exist,
         //it will be created on the server.
         channel.queueDeclare(endpointName, false, false, false, null);
    }
     
     
    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     */
     public void close() throws IOException{
         this.channel.close();
         this.connection.close();
     }
}