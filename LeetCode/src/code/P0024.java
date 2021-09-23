package code;

public class P0024 {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode prev = null;
            ListNode first = head;
            ListNode second = head.next;
            while (second != null) {
                if (prev == null) {
                    first.next = second.next;
                    second.next = first;
                    head = second;
                } else {
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
                prev = first;
                first = prev.next;
                if (first != null) {
                    second = first.next;
                } else {
                    break;
                }
            }
        }
        return head;
    }
    private static class ListNode {
        private int val;
        private ListNode next;
    }
}
