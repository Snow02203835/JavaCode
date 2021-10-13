package autumn.bytedance;

/**
 * 字节跳动第三轮技术面第2题
 * @author snow
 * @since 2021/10/09 11:30
 */
public class B0320 {
    public static void main(String[] args) {
        ListNode root = new ListNode(10,
                new ListNode(20,
                        new ListNode(30, new ListNode(40, new ListNode(50, null)))));
        ListNode temp = root;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        reverse(root, 2, 4);
        temp = root;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    private static void reverse(ListNode root, int left, int right) {
        if (root == null) {
            return;
        }
        ListNode prev = null, leftNode = null;
        ListNode rightNode = null, next = null, temp = root;
        int i = 1;
        while (temp != null) {
            next = temp.next;
            if (i+1 == left) {
                prev = temp;
            } else if (i == left) {
                leftNode = temp;
            } else if (i == right) {
                rightNode = temp;
                next = rightNode.next;
                rightNode.next = leftNode;
                if (prev == null) {
                    root.next = next;
                    root = rightNode;
                } else {
                    prev.next.next = next;
                    prev.next = rightNode;
                }
                break;
            } else if (i > left) {
                temp.next = leftNode;
                leftNode = temp;
            }
            i++;
            temp = next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
