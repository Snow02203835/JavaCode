package code;

import util.ProcessInputString;

/**
 * 设计链表
 * @author snow
 * @since 2021/10/20 16:06
 */
public class P0707 {
    public static void main(String[] args) {
        MyLinkedList list = null;
        String[] operation = new String[] {"MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"};
        int[][] values = ProcessInputString.processMatrix("[[],[1],[3],[1,2],[1],[1],[1]]");
        for (int i = 0; i < operation.length; i++) {
            switch (operation[i]) {
                case "MyLinkedList" -> list = new MyLinkedList();
                case "addAtHead" -> list.addAtHead(values[i][0]);
                case "addAtTail" -> list.addAtTail(values[i][0]);
                case "addAtIndex" -> list.addAtIndex(values[i][0], values[i][1]);
                case "get" -> System.out.println(list.get(values[i][0]));
                case "deleteAtIndex" -> list.deleteAtIndex(values[i][0]);
            }
        }
    }
    private static class MyLinkedList {

        private int size;
        private Node head;
        private Node tail;

        public MyLinkedList() {
            size = 0;
            head = tail = null;
        }

        public int get(int index) {
            int i = 0;
            Node temp = head;
            while (temp != null && i != index) {
                i++;
                temp = temp.next;
            }
            return temp == null ? -1 : temp.value;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else if (index < size){
                Node temp = head;
                while (index != 1) {
                    temp = temp.next;
                    index--;
                }
                temp.next = new Node(val, temp.next);
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                final Node node = head;
                head = head.next;
                node.next = null;
                size--;
            } else if (index > 0 && index < size) {
                Node prev = head, curr = head.next;
                while (index != 1) {
                    prev = curr;
                    curr = curr.next;
                    index--;
                }
                prev.next = curr.next;
                if (prev.next == null) {
                    tail = prev;
                }
                curr.next = null;
                size--;
            }
            if (size == 0) {
                head = tail = null;
            } else if (size == 1) {
                tail = head;
            }
        }

        private static class Node {
            private final int value;
            private Node next;

            private Node(int value) {
                this.value = value;
            }
            private Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
