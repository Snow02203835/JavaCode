package code;

import java.util.LinkedList;

/**
 * 将数据流变为多个不相交区间
 * @author snow
 * @since 2021/10/09 00:30
 */
public class P0352 {
    static class SummaryRanges {
        private final LinkedList<Range> data;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            data = new LinkedList<>();
        }

        public void addNum(int val) {
            int index = 0;
            while (index < data.size()) {
                Range temp = data.get(index);
                Range next = index+1 < data.size() ? data.get(index+1) : null;
                if (temp.start <= val && val <= temp.end) {
                    return;
                } else if (temp.end+1 == val) {
                    if (next != null && next.start == val+1) {
                        temp.end = next.end;
                        data.remove(index + 1);
                    } else {
                        temp.end++;
                    }
                    return;
                } else if (temp.start == val + 1) {
                    temp.start--;
                    return;
                } else if (val < temp.start) {
                    break;
                }
                index++;
            }
            data.add(index, new Range(val));
        }

        public int[][] getIntervals() {
            int[][] answer = new int[data.size()][2];
            for (int i = 0; i < data.size(); i++) {
                Range temp = data.get(i);
                answer[i][0] = temp.start;
                answer[i][1] = temp.end;
            }
            return answer;
        }

        private static class Range {
            private int start;
            private int end;

            public Range(int start) {
                this.start = this.end = start;
            }
        }
    }
}
