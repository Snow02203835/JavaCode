import launch.ReadPDF;
import log.Logger;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Windows extends JFrame {
    private final JTextField filePath;
    private final JTextField resultPath;
    private final JButton analyze;

    public Windows() {
        setVisible(true);
        setLayout(null);
        filePath = new JTextField();
        analyze = new JButton("提取");
        resultPath = new JTextField();
        add(filePath);
        filePath.setSize(200, 30);
        filePath.setLocation(5, 5);
        add(analyze);
        analyze.setSize(75, 30);
        analyze.setLocation(210, 5);
        analyze.addActionListener(e -> {
            String path = filePath.getText();
            if (path != null && !path.trim().equals("")) {
                Logger.log("get data from " + path);
                resultPath.setText(ReadPDF.getData(path));
            }
        });
        resultPath.disable();
        resultPath.setSize(280, 30);
        resultPath.setLocation(5, 40);
        add(resultPath);
        setSize(300, 110);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Windows();
    }
}
