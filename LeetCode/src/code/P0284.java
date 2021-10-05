package code;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 顶端迭代器
 * @author snow
 * @since 2021/10/05 23:45
 */
public class P0284 {
    static class PeekingIterator implements Iterator<Integer> {
        private int index;
        private final ArrayList<Integer> nums;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            index = 0;
            nums = new ArrayList<>();
            while (iterator.hasNext()) {
                nums.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nums.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return nums.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < nums.size();
        }
    }
}
