package expense;

import log.Logger;

import java.io.BufferedReader;

public class BusinessTravelExpense extends Expense {
    @Override
    protected void analyzeDetail(BufferedReader reader, Item item) throws Exception {
        String line;
        int timeIndex = 0, moneyIndex = 0, typeIndex = 0, totalLength = Integer.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            if (line.contains("审批记录")) {
                return;
            }
            if (line.startsWith("行程类型 出发日期/返程日期 出差天数 出发地 目的地")) {
                line = reader.readLine();
                timeIndex = 1;
            }
            String[] words = line.split(" ");
            if (line.contains("金额") && totalLength == Integer.MAX_VALUE) {
                totalLength = words.length;
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals("费用类型")) {
                        typeIndex = i;
                    } else if (words[i].equals("金额")) {
                        moneyIndex = i;
                    }
                }
            } else if (timeIndex == 1 && words[timeIndex].contains("～")) {
                getDate(words[timeIndex], item);
                timeIndex = 0;
            } else if (words.length >= totalLength) {
                if (moneyIndex == 3 && words.length == 3) {
                    Logger.log("Out of Bxx" + item.getOrderSN());
                }
                double money = Double.valueOf(words[moneyIndex].trim());
                String type = words[typeIndex];
                if (type.startsWith("交通费") || type.startsWith("自驾")) {
                    item.setTraffic(item.getTraffic() + money);
                } else if (type.startsWith("住宿费")) {
                    item.setAccommodation(item.getAccommodation() + money);
                } else if (type.startsWith("餐费")) {
                    item.setMeal(item.getMeal() + money);
                } else {
                    item.setTravel(item.getTravel() + money);
                }
            }
        }
    }
}
