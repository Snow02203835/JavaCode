package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 * @author snow
 * @since 2021/10/18 12:33
 */
public class P0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();
        findTreeNode(root, p, first);
        findTreeNode(root, q, second);
        for (int i = first.size() - 1; i >= 0; i--) {
            TreeNode node = first.get(i);
            for (int j = second.size()-1; j >= 0; j--) {
                if (node == second.get(j)) {
                    return node;
                }
            }
        }
        return null;
    }
    private void findTreeNode(TreeNode root, TreeNode target, List<TreeNode> path) {
        path.add(root);
        if (target.val < root.val) {
            findTreeNode(root.left, target, path);
        } else if (target.val > root.val) {
            findTreeNode(root.right, target, path);
        }
    }
}
