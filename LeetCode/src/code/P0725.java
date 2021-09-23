package code;

import model.ListNode;

public class P0725 {
    public static void main(String[] args) {
        P0725 main = new P0725();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        main.splitListToParts(head, 5);
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = countLen(head);
        ListNode[] answer = new ListNode[k];
        int single;
        int i;
        for (i = 0; i < k; i++) {
            single = len/k;
            if (i < len % k) {
                single = len/k + 1;
            }
            ListNode temp;
            if (head == null) {
                temp = null;
            } else {
                temp = head;
                ListNode prev = null;
                for (int j = 0; j < single; j++) {
                    prev = head;
                    head = head.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
    private int countLen(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}
