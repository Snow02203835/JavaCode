package code;

public class P0430 {

    public Node flatten(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.child != null) {
                adjust(temp, findLast(temp.child));
            }
            temp = temp.next;
        }
        return head;
    }
    private Node findLast(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    private void adjust(Node parent, Node last) {
        final Node next = parent.next;
        final Node child = parent.child;
        parent.next = child;
        parent.child = null;
        child.prev = parent;
        last.next = next;
        if (next != null) {
            next.prev = last;
        }
    }
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
