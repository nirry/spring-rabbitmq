package cn.golango.rabbitmq.psdirect;

import cn.golango.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();


        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test_simple_direct", "direct");

        //每次只发一个消息给消费者
        //channel.basicQos(1);

        for (int i = 0; i < 100; i++) {
            channel.basicPublish("test_simple_direct", "info", null, ("hello" + i).getBytes());
            System.out.println("Message Sended!!!");
        }
        channel.close();
        connection.close();
    }
}
