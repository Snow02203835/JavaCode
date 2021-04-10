package Communication;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.swing.*;

/**
 * 群聊消息接收线程，用于接收加入的群聊消息
 * @author snow create 2021/03/23 20:28
 */
public class GroupReceiver extends Thread {
    private String id;
    private String joinerId;
    private JTextArea textArea;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic topic;
    private TopicSubscriber topicSubscriber;
    private Message message;
    public GroupReceiver(String id, String joinerId, JTextArea textArea){
        this.id = id;
        this.joinerId = joinerId;
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
            connection.setClientID(id + joinerId);
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic("G_" + this.id);
            topicSubscriber = session.createDurableSubscriber(topic, this.id);
            connection.start();
            while (true) {
                System.out.println("Inside!");
                message = topicSubscriber.receive(500000L);
                if (null != message) {
                    TextMessage msg = (TextMessage)message;
                    System.out.println("Received: " + msg.getText());
                    this.textArea.append(msg.getText());
                }
                else{
                    System.out.println("Ready to break");
                    break;
                }
            }
            System.out.println("Break!!");
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
