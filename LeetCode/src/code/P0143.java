package code;

import model.ListNode;

import java.util.LinkedList;

/**
 * 重排链表
 * @author snow
 * @since 2021/10/20 17:20
 */
public class P0143 {
    public void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode middle = head, tail = head.next;
            while (tail != null) {
                tail = tail.next;
                if (tail != null) {
                    tail = tail.next;
                } else {
                    break;
                }
                middle = middle.next;
            }
            tail = middle.next;
            middle.next = null;
            LinkedList<ListNode> list = new LinkedList<>();
            while (tail != null) {
                list.add(tail);
                tail = tail.next;
            }
            middle = head;
            while (!list.isEmpty()) {
                ListNode node = list.pollLast();
                node.next = middle.next;
                middle.next = node;
                middle = middle.next.next;
            }
        }
    }
}
