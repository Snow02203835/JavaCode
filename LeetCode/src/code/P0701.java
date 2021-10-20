package code;

import model.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * @author snow
 * @since 2021/10/20 21:07
 */
public class P0701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }
    private void insert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left != null) {
                insert(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }
}
