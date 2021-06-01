package Homework.strategy;

import javax.swing.*;

public class Hand {
    private final static String profitPath = "D:\\Program\\Java\\JavaCode\\SoftwareArchitecture\\src\\main\\java\\Homework\\strategy\\";
    public static final int HAND_VALUE_GUU = 0;
    public static final int HAND_VALUE_CHO = 1;
    public static final int HAND_VALUE_PAA = 2;
    public static final Hand[] hand = {
        new Hand(HAND_VALUE_GUU),
        new Hand(HAND_VALUE_CHO),
        new Hand(HAND_VALUE_PAA),
    };
    private static final ImageIcon[] icons = {
        new ImageIcon(profitPath + "b.png"),
        new ImageIcon(profitPath + "s.png"),
        new ImageIcon(profitPath + "h.png"),
    };
    private final int handValue;
    private Hand(int handValue) {
        this.handValue = handValue;
    }
    public static Hand getHand(int handValue) {
        return hand[handValue];
    }
    public static ImageIcon getIcon(Hand hand){
        return icons[hand.handValue];
    }
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }
}

