package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> firstPath = new ArrayList<>();
        List<TreeNode> secondPath = new ArrayList<>();
        findNode(firstPath, root, p);
        findNode(secondPath, root, q);
        for (int i = firstPath.size() - 1; i >= 0; i--) {
            TreeNode temp = firstPath.get(i);
            for (int j = secondPath.size() - 1; j >= 0; j--) {
                if (temp == secondPath.get(j)) {
                    return temp;
                }
            }
        }
        return null;
    }
    private boolean findNode(List<TreeNode> path, TreeNode root, TreeNode target) {
        path.add(root);
        if (root == target) {
            return true;
        }
        if (root.left != null && findNode(path, root.left, target)) {
            return true;
        }
        if (root.right != null && findNode(path, root.right, target)) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
