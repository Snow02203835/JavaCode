package expense;

import log.Logger;

public class ExpressExpense extends DailyExpense {
    @Override
    public void addMoney(Item item, double money) {
        item.setExpress(item.getExpress() + money);
        Logger.log("Express Money: " + item.getExpress());
    }
}
