package expense;

import log.Logger;

public class SpecialTrafficExpense extends DailyExpense {

    @Override
    public void addMoney(Item item, double money) {
        item.setSpecialTraffic(item.getSpecialTraffic() + money);
        Logger.log("Special Traffic Money: " + item.getSpecialTraffic());
    }
}
