package code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 员工的重要性
 * @author snow
 * @since 2021/10/18 14:15
 */
public class P0690 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        LinkedList<Employee> list = new LinkedList<>();
        list.add(map.get(id));
        int importance = 0;
        while (!list.isEmpty()) {
            Employee mine = list.pollFirst();
            importance += mine.importance;
            for (Integer integer : mine.subordinates) {
                list.add(map.get(integer));
            }
        }
        return importance;
    }
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
