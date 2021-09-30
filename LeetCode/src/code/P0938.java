package code;

import model.TreeNode;

/**
 * 二叉搜索树的范围和
 * @author snow
 * @since 2021/09/30 14:23
 */
public class P0938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null) {
            return sum(root, low, high, 0);
        }
        return 0;
    }
    private int sum(TreeNode root, int low, int high, int sums) {
        if (root.val >= low && root.val <= high) {
            sums += root.val;
        }
        if (root.left != null) {
            sums = sum(root.left, low, high, sums);
        }
        if (root.right != null) {
            sums = sum(root.right, low, high, sums);
        }
        return sums;
    }
}
