package autumn.jingdong;

import java.util.LinkedList;

public class D2108251706 {
    private volatile D2108251706 instance;
    private D2108251706() {

    }
    public void bubbleSort(int[] nums) {
        boolean sorted = false;
        for (int i = nums.length; i >= 2; i--) {
            for (int j = 0; j < i-1; j++) {
                if (nums[j] < nums[j+1]) {
                    swap(nums, j);
                }
            }
        }
    }
    private void swap(int[] nums, int first) {
        int temp = nums[first];
        nums[first] = nums[first+1];
        nums[first+1] = temp;
    }
    public D2108251706 getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new D2108251706();
                }
            }
        }
        return instance;
    }
    public static void traver(TreeNode parent) {
        if (parent == null) {
            return;
        }
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(parent);
        while (!tree.isEmpty()) {
            TreeNode node = tree.poll();
            System.out.println(node.val);
            if (node.right != null) {
                tree.addFirst(node.right);
            }
            if (node.left != null) {
                tree.addFirst(node.left);
            }
        }
    }
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(){

        }
        private TreeNode(int val) {

        }
        private TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
