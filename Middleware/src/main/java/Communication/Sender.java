package Communication;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 发送消息类，用于发送消息到用户或者群聊
 * @author snow create 2021/03/11 18:41
 */
public class Sender {
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic topic;
    private Destination destination;
    private MessageProducer producer;
    private DateTimeFormatter dateTimeFormatter;

    public Sender(){
        this.connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yy年MM月dd日 HH:mm:ss");
    }

    /**
     * 发送消息给特定用户
     * @author snow create 2021/03/11 18:45
     * @param message
     * @return
     */
    public boolean send(MyMessage message){
        if(message.getGroup()){
            return sendGroupMessage(message);
        }
        else{
            return sendMessage(message);
        }
    }

    /**
     * 发送消息给特定用户
     * @author snow create 2021/03/11 18:45
     * @param message
     * @return
     */
    public boolean sendMessage(MyMessage message){
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(message.getReceiverId());
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, producer, message.getMessage());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != connection)
                    connection.close();
            }
            catch (Throwable ignore) {
            }
        }
        return true;
    }

    /**
     * 发送消息给特定群聊
     * @author snow create 2021/03/23 20:35
     * @param message
     * @return
     */
    public boolean sendGroupMessage(MyMessage message){
        try{
            connection = connectionFactory.createConnection();
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic(message.getReceiverId());
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            connection.start();
            sendMessage(session, producer, message.getMessage());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != connection)
                    connection.close();
            }
            catch (Throwable ignore) {
            }
        }
        return true;
    }

    /**
     * 发送消息到服务端
     * @author snow create 2021/03/29 10:30
     * @param message
     * @return
     */
    public boolean send(String message){
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("S_3835");
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, producer, message);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != connection)
                    connection.close();
            }
            catch (Throwable ignore) {
            }
        }
        return true;

    }

    /**
     * 发送消息
     * @author snow create 2021/03/11 18:50
     * @param session
     * @param producer
     * @param message
     * @throws Exception
     */
    private static void sendMessage(Session session, MessageProducer producer, String message) throws Exception {
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
    }

}
