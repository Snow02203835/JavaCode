package autumn.tencent;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class T0010 {
    public ListNode solve (ListNode[] a) {
        List<Integer> answer = new ArrayList<>();
        for (ListNode head : a) {
            answer.addAll(listToArray(head));
        }
        answer.sort(Integer::compare);
        return listToLinkedList(answer);
    }
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private List<Integer> listToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
    private ListNode listToLinkedList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.get(0), null);
        ListNode last = head;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i-1))) {
                last.next = new ListNode(list.get(i), null);
                last = last.next;
            }
        }
        return head;
    }
}
