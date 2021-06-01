package Homework.strategy;

import javax.swing.*;

public class StrategyGUI extends JFrame {
    private Integer clickTime = 0;
    public StrategyGUI(int seed1, int seed2){
        JFrame window = new JFrame("剪刀石头布");
        window.setLayout(null);
        window.setLocation(200, 200);
        window.setSize(400, 500);

        Player snow = new Player("snow", new WinningStrategy(seed1));
        Player john = new Player("john", new ProbStrategy(seed2));

        JLabel firstPlayer = new JLabel();
        firstPlayer.setBounds(30, 40, 150, 150);

        JLabel secondPlayer = new JLabel();
        secondPlayer.setBounds(210, 40, 150, 150);

        JLabel firstWins = new JLabel("snow wins: 0");
        firstWins.setBounds(55, 200, 100, 30);
        JLabel firstLose = new JLabel("snow lose: 0");
        firstLose.setBounds(55, 230, 100, 30);
        JLabel secondWins = new JLabel("john wins: 0");
        secondWins.setBounds(235, 200, 100, 30);
        JLabel secondLose = new JLabel("john lose: 0");
        secondLose.setBounds(235, 230, 100, 30);
        JLabel gameCount = new JLabel("total game: 0");
        gameCount.setBounds(150, 250, 100, 30);

        JTextArea area = new JTextArea();
        area.setBounds(10, 320, 370, 135);

        JButton play = new JButton("石头剪刀布");
        play.setBounds(150, 280, 100, 30);
        play.addActionListener(e -> {
            clickTime++;
            if(clickTime > 7){
                clickTime = 0;
                area.setText("");
            }
            Hand snowHand = snow.nextHand();
            Hand johnHand = john.nextHand();
            firstPlayer.setIcon(Hand.getIcon(snowHand));
            secondPlayer.setIcon(Hand.getIcon(johnHand));
            if (snowHand.isStrongerThan(johnHand)) {
                area.append("Winner:" + snow);
                snow.win();
                john.lose();
                firstWins.setText("snow wins: " + snow.getWinCount());
                secondLose.setText("john lose: " + john.getLoseCount());
            } else if (snowHand.isWeakerThan(johnHand)) {
                area.append("Winner:" + john);
                snow.lose();
                john.win();
                firstWins.setText("snow lose: " + snow.getLoseCount());
                secondLose.setText("john wins: " + john.getWinCount());
            } else {
                area.append("Even...\n");
                snow.even();
                john.even();
            }
            gameCount.setText("total game: " + snow.getGameCount());
        });

        window.add(firstPlayer);
        window.add(secondPlayer);
        window.add(firstWins);
        window.add(firstLose);
        window.add(secondWins);
        window.add(secondLose);
        window.add(gameCount);
        window.add(play);
        window.add(area);
        window.setVisible(true);
    }
}
