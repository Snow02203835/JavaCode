package Ex01;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {
        // ConnectionFactory
        ConnectionFactory connectionFactory;
        // Connection
        Connection connection = null;
        // Session
        Session session;
        // Destination
        Destination destination;
        // MessageProducer
        MessageProducer producer;
        // TextMessage message;

        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("FirstQueue");
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, producer);
            session.commit();
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

    public static void sendMessage(Session session, MessageProducer producer)
            throws Exception {
        for (int i = 1; i <= SEND_NUMBER; i++) {
            TextMessage message = session
                    .createTextMessage("ActiveMq 发送方发送： "+ i);
            System.out.println("发送方发送了" + i);
            producer.send(message);
        }
    }

}
