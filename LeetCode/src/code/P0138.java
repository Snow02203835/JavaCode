package code;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 * @author snow
 * @since 2021/10/20 15:43
 */
public class P0138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, null);
            temp = temp.next;
        }
        Node newHead = null, curr;
        temp = head;
        while (temp != null) {
            curr = connect(map, temp);
            curr.next = connect(map, temp.next);
            curr.random = connect(map, temp.random);
            if (newHead == null) {
                newHead = curr;
            }
            temp = temp.next;
        }
        return newHead;
    }
    private Node connect(HashMap<Node, Node> map, Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = map.get(node);
        if (newNode == null) {
            newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return newNode;
    }
    private static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
