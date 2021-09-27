package code;

import model.TreeNode;

import java.util.LinkedList;

/**
 * 路径总和III
 * @author snow
 * @since 2021/09/28 01:20
 */
public class P0437 {
    public int pathSum(TreeNode root, int targetSum) {
        int sums = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            if (node != null) {
                sums += pathNum(node, 0, 0, targetSum);
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
            }
        }
        return sums;
    }
    private int pathNum(TreeNode root, int num, int current, int target) {
        current += root.val;
        if (current == target) {
            num++;
        }
        if (root.left != null) {
            num = pathNum(root.left, num, current, target);
        }
        if (root.right != null) {
            num = pathNum(root.right, num, current, target);
        }
        return num;
    }
}
