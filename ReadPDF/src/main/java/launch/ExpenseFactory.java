package launch;

import expense.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpenseFactory {
    private static final Map<String, Expense> map = new HashMap<>();
    private static final Set<String> types;

    static {
        map.put("差旅", new BusinessTravelExpense());
        map.put("打印费", new PrintExpense());
        map.put("快递费", new ExpressExpense());
        map.put("团建费", new TeamExpense());
        map.put("自驾报销", new SelfDriveExpense());
        map.put("本地特殊", new SpecialTrafficExpense());
        Expense otherDailyExpense = new OtherDailyExpense();
        map.put("其他费", otherDailyExpense);
        map.put("培训费", otherDailyExpense);
        map.put("文化费", otherDailyExpense);
        types = map.keySet();
    }
    public static Expense getExpense(String line) {
        for (String type : types) {
            if (line.contains(type)) {
                return map.get(type);
            }
        }
        throw new IllegalArgumentException("不支持的报销单据类型" + line);
    }
}
