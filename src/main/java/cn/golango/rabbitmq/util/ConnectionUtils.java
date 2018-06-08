package cn.golango.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.31.200");
        factory.setPort(5672);
        factory.setVirtualHost("/cc");
        factory.setUsername("cc");
        factory.setPassword("123456");

        return factory.newConnection();

    }

}
