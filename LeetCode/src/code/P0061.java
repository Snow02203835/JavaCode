package code;

import model.ListNode;

public class P0061 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode count = head;
        int len = 0;
        while (count != null) {
            len++;
            count = count.next;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode first = head;
        k = len - k;
        count = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            prev = count;
            count = count.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        head = count;
        while (count.next != null) {
            count = count.next;
        }
        count.next = first;
        return head;
    }
}
