package Communication;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.swing.*;
import java.io.Serializable;

/**
 * 个人消息接收线程，用于接收别人发给自己的消息
 * @author snow create 2021/03/11 18:35
 */
public class Receiver extends Thread {
    private String id;
    private JTextArea textArea;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer consumer;
    public Receiver(String id, JTextArea textArea){
        this.id = id;
        this.textArea = textArea;
        this.connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
    }

    @Override
    public void run() {
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("B_" + this.id);
            consumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) consumer.receive(500000);
                if (null != message) {
                    this.textArea.append(message.getText());
                    System.out.println("收到消息: " + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }

    }
}
