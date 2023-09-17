package expense;

import java.io.BufferedReader;

public abstract class DailyExpense extends Expense {
    @Override
    protected void analyzeDetail(BufferedReader reader, Item item) throws Exception {
        String line;
        int timeIndex = 0, moneyIndex = 0, totalLength = Integer.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            if (line.contains("审批记录")) {
                return;
            }
            String[] words = line.split(" ");
            if (line.contains("金额")) {
                totalLength = words.length;
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals("发生时间")) {
                        timeIndex = i;
                    } else if (words[i].equals("金额")) {
                        moneyIndex = i;
                    }
                }
            } else if (words.length >= totalLength) {
                getDate(words[timeIndex], item);
                addMoney(item, Double.valueOf(words[moneyIndex].trim()));
            }
        }
    }

    public abstract void addMoney(Item item, double money);
}
