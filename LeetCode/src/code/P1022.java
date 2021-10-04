package code;

import model.TreeNode;

import java.util.LinkedList;

/**
 * 从根到叶的二进制之和
 * @author snow
 * @since 2021/09/29 16:48
 */
public class P1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root != null) {
            return travel(root, new LinkedList<>());
        }
        return 0;
    }
    private int travel(TreeNode root, LinkedList<Integer> path) {
        int value = 0;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            value = listToNum(path);
        }
        if (root.left != null) {
            value += travel(root.left, path);
        }
        if (root.right != null) {
            value += travel(root.right, path);
        }
        path.removeLast();
        return value;
    }
    private int listToNum(LinkedList<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum = sum*2 + value;
        }
        return sum;
    }
}
