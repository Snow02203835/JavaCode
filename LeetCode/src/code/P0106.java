package code;

import util.ProcessInputString;

public class P0106 {
    public static void main(String[] args) {
        P0106 solution = new P0106();
        solution.buildTree(ProcessInputString.processVector("[9,3,15,20,7]"), ProcessInputString.processVector("[9,15,7,20,3]"));
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        TreeNode tree = new TreeNode(postorder[pe]);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                if (i != is) {
                    tree.left = buildTree(inorder, is, i-1, postorder, ps, ps+i-is-1);
                }
                if (i != ie) {
                    tree.right = buildTree(inorder, i+1, ie, postorder, i-is+ps, pe-1);
                }
            }
        }
        return tree;
    }
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val) {
            this.val = val;
        }
    }
}
