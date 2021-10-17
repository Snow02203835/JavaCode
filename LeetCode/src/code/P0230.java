package code;

import model.TreeNode;

/**
 * 二叉搜索树中第k小的元素
 * @author snow
 * @since 2021/10/17 18:23
 */
public class P0230 {
    public int kthSmallest(TreeNode root, int k) {
        return -find(root, 1, k);
    }
    private int find(TreeNode root, int curr, int k) {
        if (root.left != null) {
            curr = find(root.left, curr, k);
            if (curr < 0) {
                return curr;
            }
        }
        if (root.right != null) {
            int temp = find(root.right, curr, k);
            if (temp < 0) {
                return temp;
            }
        }
        if (root.left == null && root.right == null) {
            curr++;
        }
        if (curr == k) {
            return -root.val;
        } else {
            return curr;
        }
    }
}
