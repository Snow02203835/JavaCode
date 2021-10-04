package code;

import model.ListNode;

import java.util.LinkedList;

/**
 * 两数相加II
 * @author snow
 * @since 2021/09/29 15:40
 */
public class P0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> list1 = toList(l1);
        LinkedList<ListNode> list2 = toList(l2);
        if (list1.size() < list2.size()) {
            LinkedList<ListNode> temp = list1;
            list1 = list2;
            list2 = temp;
            l1 = l2;
        }
        while (!list1.isEmpty()) {
            ListNode node1 = list1.pollLast();
            if (!list2.isEmpty()) {
                ListNode node2 = list2.pollLast();
                node1.val += node2.val;
            }
            if (node1.val >= 10) {
                if (list1.isEmpty()) {
                    l1 = new ListNode(node1.val/10, l1);
                } else {
                    list1.getLast().val += node1.val/10;
                }
                node1.val %= 10;
            }
        }
        return l1;
    }
    private LinkedList<ListNode> toList(ListNode list) {
        LinkedList<ListNode> nodes = new LinkedList<>();
        ListNode temp = list;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        return nodes;
    }
}
