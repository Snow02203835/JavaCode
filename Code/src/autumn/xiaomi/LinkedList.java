package autumn.xiaomi;

import java.util.*;

public class LinkedList {

    private static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        int len = 0;
        ListNode first = head;
        while(first != null) {
            len++;
            first = first.next;
        }
        ListNode prev = null;
        first = head;
        for (int i = 0; i < len-n; i++) {
            prev = first;
            first = first.next;
        }
        if (prev == null) {
            return head.next;
        } else {
            prev.next = first.next;
            first.next = null;
            return head;
        }
    }
}
