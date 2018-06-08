package cn.golango.rabbitmq.work;

import cn.golango.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("test_simple_queue", false, false, false, null);

        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", "test_simple_queue", null, ("hello" + i).getBytes());
        }
        channel.close();
        connection.close();
    }
}
