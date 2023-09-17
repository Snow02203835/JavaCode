package expense;

import log.Logger;

import java.io.BufferedReader;
import java.time.LocalDate;

public abstract class Expense {
    protected static final String ORDER_SN = "流水号";
    protected static final String NAME = "申请人";
    protected static final String WORKER_SN = "申请人工号";
    protected static final String TOTAL_FEE = "费用总金额";
    protected static final String DETAIL = "报销明细";
    protected static final String BUSINESS_TRAVEL = "差旅行程明细";

    public Item getInfo(BufferedReader reader) {
        Item item = new Item();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains(ORDER_SN)) {
                    int startOfOrderSN = line.indexOf(ORDER_SN) + ORDER_SN.length();
                    item.setOrderSN(line.substring(startOfOrderSN));
                } else if (line.contains(NAME) && !line.contains(WORKER_SN)) {
                    int startOfName= line.indexOf(NAME) + NAME.length();
                    int startOfWorkerNum = line.indexOf('(', startOfName);
                    item.setName(line.substring(startOfName, startOfWorkerNum));
                    item.setWorkerNum(line.substring(startOfWorkerNum+1, line.indexOf(')', startOfWorkerNum)));
                } else if (line.startsWith(TOTAL_FEE)) {
                    int startOfTotal = line.indexOf(TOTAL_FEE) + TOTAL_FEE.length();
                    item.setTotal(Double.parseDouble(line.substring(startOfTotal).trim()));
                } else if (line.contains(DETAIL) || line.contains(BUSINESS_TRAVEL)) {
                    analyzeDetail(reader, item);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return item;
    }

    protected abstract void analyzeDetail(BufferedReader reader, Item item) throws Exception;

    protected void getDate(String dateStr, Item item) {
        if (dateStr.contains("～")) {
            String[] timeStr = dateStr.split("～");
            LocalDate startDate = LocalDate.parse(timeStr[0]);
            LocalDate endDate = LocalDate.parse(timeStr[1]);
            item.setStartDate(startDate);
            item.setEndDate(endDate);
            Logger.log("Start: " + startDate + ", end: " + endDate);
        } else {
            LocalDate startDate = LocalDate.parse(dateStr);
            item.setStartDate(startDate);
            item.setEndDate(startDate);
            Logger.log("Start: " + startDate + ", end: " + startDate);
        }
    }
}
