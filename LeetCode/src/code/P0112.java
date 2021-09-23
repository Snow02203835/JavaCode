package code;

import model.TreeNode;

public class P0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return path(root, 0, targetSum);
    }
    private boolean path(TreeNode root, int total, int target) {
        if (root == null) {
            return false;
        }
        total += root.val;
        if (root.left == null && root.right == null) {
            return total == target;
        }
        return path(root.left, total, target) || path(root.right, total, target);
    }
}
