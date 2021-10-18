package code;

import model.ListNode;

/**
 * 回文链表
 * @author snow
 * @since 2021/10/18 13:05
 */
public class P0234 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(new P0234().isPalindrome(listNode));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head, last = head.next;
        if (last != null) {
            while (last.next != null) {
                last = last.next;
                if (last.next != null) {
                    last = last.next;
                } else {
                    break;
                }
                middle = middle.next;
            }
            last = reverseList(middle.next);
            middle.next = null;
            middle = head;
            while (middle != null) {
                if (last.val != middle.val) {
                    return false;
                }
                last = last.next;
                middle = middle.next;
            }
        }
        return true;
    }
    private ListNode reverseList(ListNode root) {
        ListNode next = null, last;
        while (true) {
            last = root.next;
            root.next = next;
            next = root;
            if (last == null) {
                return root;
            } else {
                root = last;
            }
        }
    }
}
