package autumn.bytedance.douyin;

/**
 * 字节跳动-抖音客户端-第一次技术面
 *    使用数组实现一个循环队列，实现
 *          构造函数，传入队列的最大长度
 *          front: 从队首获取元素。如果队列为空，返回 -1 。
 *          rear: 获取队尾元素。如果队列为空，返回 -1 。
 *          enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *          deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *          isEmpty(): 检查循环队列是否为空。
 *          isFull(): 检查循环队列是否已满
 * @author snow
 * @since 2021/10/26 15:50
 */
public class B0110 {
    static class MyQueue {
        private int front;
        private int rear;
        private boolean full;
        private final int[] room;
        private final int maxLen;
        public MyQueue(int l) {
            full = false;
            maxLen = l;
            front = rear = 0;
            room = new int[l];
        }

        public int front() {
            if (!isEmpty()) {
                return room[front];
            }
            return -1;
        }

        public int rear() {
            if (!isEmpty()) {
                return rear == 0? room[maxLen-1] : room[rear-1];
            }
            return -1;
        }

        public boolean enQueue(int value) {
            if (!full) {
                room[rear++] = value;
                rear = rear == maxLen ? 0 : rear;
                full = rear == front;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = ++front == maxLen ? 0 : front;
                full = false;
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return !full && front == rear;
        }

        public boolean isFull() {
            return full;
        }
    }
}
