package code;

import util.ProcessInputString;

import java.util.HashMap;

public class P0146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        String[] op = new String[] {"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] matrix = ProcessInputString.processMatrix("[[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]");
        for (int i = 0; i < op.length; i++) {
            if ("put".equals(op[i])) {
                cache.put(matrix[i][0], matrix[i][1]);
            } else if ("get".equals(op[i])) {
                System.out.println(cache.get(matrix[i][0]));
            }
        }
    }
    static class LRUCache {
        int size;
        int next;
        int[] value;
        int[] times;
        HashMap<Integer, Integer> keyIndex;
        HashMap<Integer, Integer> indexKey;
        public LRUCache(int capacity) {
            size = 0;
            next = 1;
            value = new int[capacity];
            times = new int[capacity];
            keyIndex = new HashMap<>(capacity*2);
            indexKey = new HashMap<>(capacity*2);
        }

        public int get(int key) {
            Integer value;
            if (size != 0 && (value = keyIndex.get(key)) != null) {
                times[value] = next++;
                return this.value[value];
            }
            return -1;
        }

        public void put(int key, int value) {
            int index = -1;
            if (keyIndex.containsKey(key)) {
                index = keyIndex.get(key);
            } else {
                if (size != this.value.length) {
                    index = size++;
                } else {
                    int min = 0x7fffffff;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i] < min) {
                            min = times[i];
                            index = i;
                        }
                    }
                    int oldKey = indexKey.get(index);
                    keyIndex.remove(oldKey);
                }
                keyIndex.put(key, index);
                indexKey.put(index, key);
            }
            this.times[index] = next++;
            this.value[index] = value;
        }
    }
}
