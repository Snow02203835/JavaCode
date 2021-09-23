package model;

import util.ProcessInputString;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode toList(String str) {
        int[] vector = ProcessInputString.processVector(str);
        ListNode last = new ListNode(vector[vector.length-1]);
        for (int i = vector.length - 2; i >= 0; i--) {
            last = new ListNode(vector[i], last);
        }
        return last;
    }
}
