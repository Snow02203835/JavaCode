package code;

import model.TreeNode;

/**
 * 平衡二叉树
 * @author snow
 * @since 2021/10/02 16:10
 */
public class P0110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(4, null, new TreeNode(5)));
        P0110 main = new P0110();
        System.out.println(main.isBalanced(root));
    }
    public boolean isBalanced(TreeNode root) {
        return root == null || isBalanced(root, 0) != -1;
    }
    private int isBalanced(TreeNode root, int deep) {
        int left = deep, right = deep;
        if (root.left != null) {
            left = isBalanced(root.left, deep+1);
        }
        if (root.right != null) {
            right = isBalanced(root.right, deep+1);
        }
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}
