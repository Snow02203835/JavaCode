package code;

import model.ListNode;

public class P0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null, temp = head;
        while (temp != null) {
            if (temp.val == val) {
                if (prev == null) {
                    head = head.next;
                    temp = temp.next;
                } else {
                    prev.next = temp.next;
                    ListNode next = temp.next;
                    temp.next = null;
                    temp = next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
