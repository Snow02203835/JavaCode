package expense;

import log.Logger;

public class TeamExpense extends DailyExpense {
    @Override
    public void addMoney(Item item, double money) {
        item.setTeam(item.getTeam() + money);
        Logger.log("Team Money: " + item.getTeam());
    }
}
