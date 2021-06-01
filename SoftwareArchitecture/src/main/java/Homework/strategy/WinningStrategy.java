package Homework.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private boolean won;
    private Hand prevHand;
    private final Random random;

    public WinningStrategy(int seed) {
        won = false;
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }
    @Override
    public void study(boolean win) {
        won = win;
    }
}
