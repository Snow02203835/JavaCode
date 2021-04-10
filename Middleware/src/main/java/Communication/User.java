package Communication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 用户界面，用于用户操作以及显示消息
 * @author snow create 2021/03/11 19:00
 *            modified 2021/03/23 21:03
 *            modified 2021/03/24 19:43
 */
public class User extends JFrame {
    private String id;
    private String name;
    private Sender sender;
    private Receiver receiver;
    private MyMessage message;
    private List<String> joinedGroupIds;

    public User(String name) {
        this.name = name;
        sender = new Sender();
        joinedGroupIds = new ArrayList<>();
        Random random = new Random();
        id = Integer.toString(random.nextInt(100000));
        message = new MyMessage(this.id);
        JTextArea messageReceived = new JTextArea();
        messageReceived.setBounds(10, 120, 370, 185);
        receiver = new Receiver(id, messageReceived);
        receiver.start();
        JFrame f = new JFrame("MiddleTest" + id);
        f.setSize(400, 350);//设置容器尺寸
        f.setLocation(200, 200);//设置容器位置
        f.setLayout(null);//设置布局。

        JLabel idLabel = new JLabel();
        idLabel.setText("ID: " + id);
        idLabel.setBounds(10, 10, 100, 30);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: " + this.name);
        nameLabel.setBounds(100, 10, 200, 30);

        JCheckBox autoTranslate = new JCheckBox("自动翻译");
        autoTranslate.setSelected(true);
        autoTranslate.setBounds(180, 10, 80, 30);

        JCheckBox groupMessage = new JCheckBox("群聊");
        groupMessage.setBounds(260, 10, 50, 30);

        JCheckBox fileMessage = new JCheckBox("文件");
        fileMessage.setBounds(320, 10, 50, 30);

        JTextField receiverId = new JTextField();
        receiverId.setBounds(10, 40, 80, 30);

        JTextField messageField = new JTextField();
        messageField.setBounds(100, 40, 210, 30);

        JButton sendButton = new JButton("发送");
        sendButton.setBounds(320, 40, 60, 30);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 对话框
                if(receiverId.getText() == null || receiverId.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "发送对象不能为空！");
                }
                else if(messageField.getText() == null || messageField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "发送内容不能为空！");
                }
                else {
                    message.setMessage(autoTranslate.isSelected(), fileMessage.isSelected(), groupMessage.isSelected(), messageField.getText(), receiverId.getText());
                    sender.send(message);
                }
            }
        });

        JTextField groupId = new JTextField();
        groupId.setBounds(10, 80, 80, 30);

        JButton joinGroup = new JButton("加入群聊");
        joinGroup.setBounds(100, 80, 100, 30);
        joinGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(groupId.getText() != null && !groupId.equals("")){
                    boolean joined = false;
                    for(String joinedGroupId : joinedGroupIds){
                        if(joinedGroupId.equals(groupId.getText())){
                            joined = true;
                            JOptionPane.showMessageDialog(null, "你已经加入该群聊");
                        }
                    }
                    if(!joined) {
                        joinedGroupIds.add(groupId.getText());
                        GroupReceiver groupReceiver = new GroupReceiver(groupId.getText(), id, messageReceived);
                        groupReceiver.start();
                    }
                }
            }
        });

        JButton createGroup = new JButton("创建群聊");
        createGroup.setBounds(210, 80, 100, 30);

        JButton clearText = new JButton("清空");
        clearText.setBounds(320, 80, 60, 30);
        clearText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageReceived.setText("");
            }
        });

        f.add(idLabel);
        f.add(nameLabel);
        f.add(receiverId);
        f.add(messageField);
        f.add(messageReceived);
        f.add(sendButton);
        f.add(groupId);
        f.add(createGroup);
        f.add(joinGroup);
        f.add(autoTranslate);
        f.add(groupMessage);
        f.add(fileMessage);
        f.add(clearText);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面关闭后程序结束

        f.setVisible(true);//界面可视化
    }
}
