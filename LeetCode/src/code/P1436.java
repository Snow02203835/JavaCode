package code;

import java.util.HashSet;
import java.util.List;

/**
 * 旅行终点站
 * @author snow
 * @since 2021/10/01 10:58
 */
public class P1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> router : paths) {
            set.add(router.get(0));
        }
        for (List<String> router : paths) {
            if (!set.contains(router.get(1))) {
                return router.get(1);
            }
        }
        return "";
    }
}
