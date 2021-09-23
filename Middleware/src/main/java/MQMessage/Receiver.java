package MQMessage;

import javax.swing.*;

public class Receiver extends JFrame {
    public Receiver(){
        JFrame window = new JFrame("消息浏览");
        window.setLayout(null);
        window.setLocation(100, 100);
        window.setSize(300, 420);

        JTextArea area = new JTextArea();
        area.setEnabled(false);
        area.setBounds(5, 5, 275, 340);

        JButton clear = new JButton("清空消息");
        clear.setBounds(5, 350, 100, 30);
        clear.addActionListener(e->{
            area.setText("");
        });
        MQListener listener = new MQListener(area);

        window.add(clear);
        window.add(area);
        window.setVisible(true);
    }
}
