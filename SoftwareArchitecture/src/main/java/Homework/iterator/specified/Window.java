package Homework.iterator.specified;

import Homework.iterator.Iterator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window(Aggregate aggregate){
        Iterator iterator = aggregate.iterator();
        JFrame window = new JFrame("");
        window.setSize(400, 510);
        window.setLocation(200, 200);
        window.setLayout(null);

        Introduction introduction = (Introduction) iterator.begin();
        ImageIcon imageIcon = new ImageIcon("D:\\Ablum\\头像\\" + introduction.getPicture());
        JLabel picture = new JLabel(imageIcon);
        picture.setBounds(5, 5, 390, 390);
        JLabel text = new JLabel(introduction.getText());
        text.setBounds(5, 400, 390, 30);

        JButton begin = new JButton("第一张");
        begin.setBounds(5, 435, 90, 30);
        begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Begin Click");
                Introduction introduction1 = (Introduction) iterator.begin();
                System.out.println(introduction1.getPicture() + " " + introduction1.getText());
                ImageIcon imageIcon1 = new ImageIcon("D:\\Ablum\\头像\\" + introduction1.getPicture());
                picture.setIcon(imageIcon1);
                text.setText(introduction1.getText());
            }
        });
        JButton last = new JButton("上一张");
        last.setBounds(100, 435, 90, 30);
        begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Last Click");
                if (iterator.hasLast()){
                    Introduction introduction1 = (Introduction) iterator.last();
                    System.out.println(introduction1.getPicture() + " " + introduction1.getText());
                    ImageIcon imageIcon1 = new ImageIcon("D:\\Ablum\\头像\\" + introduction1.getPicture());
                    picture.setIcon(imageIcon1);
                    text.setText(introduction1.getText());
                }
            }
        });
        JButton next = new JButton("下一张");
        next.setBounds(195, 435, 90, 30);
        begin.addActionListener(e -> {
            System.out.println("Next Click");
            if(iterator.hasNext()) {
                Introduction introduction1 = (Introduction) iterator.next();
                System.out.println(introduction1.getPicture() + " " + introduction1.getText());
                ImageIcon imageIcon1 = new ImageIcon("D:\\Ablum\\头像\\" + introduction1.getPicture());
                picture.setIcon(imageIcon1);
                text.setText(introduction1.getText());
            }
        });
        JButton end = new JButton("最后一张");
        end.setBounds(290, 435, 90, 30);
        begin.addActionListener(e -> {
            System.out.println("End Click");
            Introduction introduction1 = (Introduction) iterator.end();
            System.out.println(introduction1.getPicture() + " " + introduction1.getText());
            ImageIcon imageIcon1 = new ImageIcon("D:\\Ablum\\头像\\" + introduction1.getPicture());
            picture.setIcon(imageIcon1);
            text.setText(introduction1.getText());
        });

        window.add(picture);
        window.add(text);
        window.add(begin);
        window.add(next);
        window.add(last);
        window.add(end);
        window.setVisible(true);
    }
}
