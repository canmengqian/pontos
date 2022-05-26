package com.pontons.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className ClientUtil
 * @description TODO
 * @date 2022/4/29
 */
public class ClientUtil {
    static Connection connection;

    static {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setAutomaticRecoveryEnabled(true);
        // TODO factory.setClientProperties();
        // RPC调用超时
        factory.setChannelRpcTimeout(60000);
        // 检查RPC响应类型
        factory.setChannelShouldCheckRpcResponseType(true);
        //设置连接超时
        factory.setConnectionTimeout(60000);
        // 认证提供器
        //factory.setCredentialsProvider();
        // 握手超时
        factory.setHandshakeTimeout(60000);
        factory.setHost("localhost");
        factory.setPort(5672);
        try {
            connection = factory.newConnection("test-client");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Channel createChannel() {
        if (connection != null) {
            try {
                return connection.createChannel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
