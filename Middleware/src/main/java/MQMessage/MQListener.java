package MQMessage;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.swing.*;

@RocketMQMessageListener(topic = "orders",
        consumerGroup = "mine",
        nameServer = "localhost:9876"
)
@Component
public class MQListener implements RocketMQListener<Object> {
    private final JTextArea area;
    public MQListener(JTextArea area){
        this.area = area;
    }
    @Override
    public void onMessage(Object o) {
        area.append(o.toString() + "\n");
    }
}
