package expense;

import log.Logger;

public class PrintExpense extends DailyExpense {
    @Override
    public void addMoney(Item item, double money) {
        item.setPrint(item.getPrint() + money);
        Logger.log("Print Money: " + item.getPrint());
    }
}
