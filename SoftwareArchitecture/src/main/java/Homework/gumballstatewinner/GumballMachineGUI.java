package Homework.gumballstatewinner;

import javax.swing.*;

public class GumballMachineGUI extends JFrame {
    public GumballMachineGUI(int total){

        JTextArea info = new JTextArea();
        info.setBounds(10, 270, 350, 90);
        GumballMachine machine = new GumballMachine(total, info);
        String path = "D:\\Program\\Java\\JavaCode\\SoftwareArchitecture\\src\\main\\java\\Homework\\gumballstatewinner\\";
        JFrame window = new JFrame("口香糖机");
        window.setLayout(null);
        window.setSize(500, 400);
        window.setLocation(300, 300);

        JLabel gumballImage = new JLabel(new ImageIcon(path + "gumball.jpg"));
        gumballImage.setBounds(10, 10, 350, 250);

        JLabel gumballNumber = new JLabel("剩余数量: " + total);
        gumballNumber.setBounds(380, 230, 100, 30);

        JButton coin = new JButton(new ImageIcon(path + "coin.jpg"));
        coin.setBounds(380, 10, 100, 100);
        coin.addActionListener(e -> {
            machine.insertQuarter();
        });

        JButton crank = new JButton(new ImageIcon(path + "crank.jpg"));
        crank.setBounds(380, 120, 100, 100);
        crank.addActionListener(e -> {
            machine.turnCrank();
            gumballNumber.setText("剩余数量：" + machine.getCount());
        });

        JButton clear = new JButton("清空显示屏");
        clear.setBounds(380, 270, 100, 30);
        clear.addActionListener(e -> {
            info.setText("");
        });

        window.add(info);
        window.add(coin);
        window.add(crank);
        window.add(clear);
        window.add(gumballImage);
        window.add(gumballNumber);
        window.setVisible(true);
    }
}
