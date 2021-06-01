package Homework.strategy;

public class Player {
    private final String name;
    private final Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    public Hand nextHand() {
        return strategy.nextHand();
    }
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }
    public void even() {                // ƽ��
        gameCount++;
    }
    public String toString() {
        return "[" + name + ":" + gameCount + " games, " + winCount + " win, " + loseCount + " lose" + "]\n";
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public int getGameCount() {
        return gameCount;
    }
}

