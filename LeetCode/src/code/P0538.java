package code;

import model.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 * @author snow
 * @since 2021/09/29 13:08
 */
public class P0538 {
    public static void main(String[] args) {
        P0538 main = new P0538();
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7, null, new TreeNode(8))));
        main.convertBST(root);
    }
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convert(root, 0);
        }
        return root;
    }
    private int convert(TreeNode root, int value) {
        if (root.right != null) {
            value += convert(root.right, value);
        }
        root.val += value;
        value = root.val;
        if (root.left != null) {
            value = convert(root.left, value);
        }
        return value;
    }
}
