package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和II
 * @author snow
 * @since 2021/09/28 01:10
 */
public class P0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root != null) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(root.val);
            path(answer, path, root, root.val, targetSum);
        }
        return answer;
    }
    private void path(List<List<Integer>> answer, LinkedList<Integer> path, TreeNode root, int current, int target) {
        if (root.left == null && root.right == null && current == target) {
            answer.add(new LinkedList<>(path));
        }
        if (root.left != null) {
            path.add(root.left.val);
            path(answer, path, root.left, current + root.left.val, target);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            path(answer, path, root.right, current + root.right.val, target);
            path.removeLast();
        }
    }
}
