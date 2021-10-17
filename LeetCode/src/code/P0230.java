package code;

import model.TreeNode;

/**
 * 二叉搜索树中第k小的元素
 * @author snow
 * @since 2021/10/17 18:23
 */
public class P0230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7))),
                new TreeNode(12,
                        new TreeNode(10,
                                new TreeNode(9),
                                new TreeNode(11)),
                        new TreeNode(14,
                                new TreeNode(13),
                                new TreeNode(15))));
        P0230 main = new P0230();
        for (int i = 1; i < 16; i++) {
            System.out.println(main.kthSmallest(root, i));
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        return -find(root, 1, k) - 100;
    }
    private int find(TreeNode root, int curr, int k) {
        if (root.left != null) {
            curr = find(root.left, curr, k);
            if (curr < 0) {
                return curr;
            } else {
                curr++;
            }
        }
        int temp = curr;
        if (root.right != null) {
            temp = find(root.right, curr + 1, k);
            if (temp < 0) {
                return temp;
            }
        }
        if (curr == k) {
            return -(root.val + 100);
        } else {
            return temp;
        }
    }
}
