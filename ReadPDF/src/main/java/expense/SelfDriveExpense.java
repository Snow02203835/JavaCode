package expense;

import log.Logger;

public class SelfDriveExpense extends DailyExpense {
    @Override
    public void addMoney(Item item, double money) {
        item.setSelfDrive(item.getSelfDrive() + money);
        Logger.log("Self Drive Money: " + item.getSelfDrive());
    }
}
