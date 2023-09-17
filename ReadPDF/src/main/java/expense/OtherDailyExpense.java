package expense;

import log.Logger;

public class OtherDailyExpense extends DailyExpense {
    @Override
    public void addMoney(Item item, double money) {
        item.setDaily(item.getDaily() + money);
        Logger.log("Daily Money: " + item.getDaily());
    }
}
