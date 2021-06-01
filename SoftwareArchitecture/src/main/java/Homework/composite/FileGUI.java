package Homework.composite;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileGUI extends JFrame {

    private Directory root = null;

    public FileGUI(){
        JFrame window = new JFrame("文件管理");
        window.setLayout(null);
        window.setLocation(100, 100);
        window.setSize(400, 600);

        JTextArea area = new JTextArea();
        area.setEnabled(false);
        area.setBounds(10, 10, 365, 505);

        JTextField path = new JTextField();
        path.setBounds(10, 525, 255, 30);
        JButton enter = new JButton("进入");
        enter.setBounds(275, 525, 100, 30);
        enter.addActionListener(e -> {
            String dir = path.getText();
            if (dir == null || dir.isBlank()){
                area.setText("Invalid path!!!");
            }
            else{
                area.setText("");
                dir = dir.replace('\\', '/');
                System.out.println(dir);
                if (root != null) {
                    root = root.insideSubDirectory(dir);
//                    if (root != null){
//                        dir = "./" + dir;
//                    }
                    System.out.println(root);
                }
                if(getFileName(dir, area)){
                    if (dir.indexOf('.') == 0){
                        root.printList(dir);
                    }
                    else{
                        root.printList(dir.substring(0, dir.lastIndexOf('/')));
                    }
                }
                else{
                    area.setText("Path don't exist!!!");
                }
            }
        });

        window.add(area);
        window.add(path);
        window.add(enter);
        window.setVisible(true);
    }

    private boolean getFileName(String filePath, JTextArea area){
        if(filePath != null && !filePath.isBlank()){
            java.io.File file = new java.io.File(filePath);
            if(!file.exists()){
                return false;
            }
            if (root == null) {
                root = new Directory(filePath.substring(filePath.lastIndexOf('/') + 1), area);
            }
            java.io.File[] fileArray= file.listFiles();
            if (fileArray != null) {
                java.io.File fileName;
                for (java.io.File value : fileArray) {
                    fileName = value;
                    if (fileName.isDirectory()) {
                        System.out.println(fileName.getName());
                        root.add(new Directory(fileName.getName(), area));
                    }
                    else {
                        System.out.println(fileName.getName());
                        root.add(new Homework.composite.File(fileName.getName(), (int)fileName.length(), area));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
