package code;

public class P0098 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(32,
                new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null),
                new TreeNode(47, null, new TreeNode(56)));
        P0098 solution = new P0098();
        System.out.println(solution.isValidBST(tree));
    }
    public boolean isValidBST(TreeNode root) {
        int min = 0x80000000;
        if (root.left != null) {
            min = getMax(root.left);
        }
        int max = 0x7fffffff;
        if (root.right != null) {
            max = getMin(root.right);
        }
        return root.val >= min && root.val <= max;
    }
    private int getMax(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int min = root.val;
        if (root.left != null) {
            min = getMax(root.left);
        }
        int max = root.val;
        if (root.right != null) {
            max = getMin(root.right);
        }
        if (root.val < min || max < root.val) {
            return 0x7fffffff;
        }
        return max;
    }
    private int getMin(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int min = root.val;
        if (root.left != null) {
            min = getMax(root.left);
        }
        int max = root.val;
        if (root.right != null) {
            max = getMin(root.right);
        }
        if (root.val < min || max < root.val) {
            return 0x80000000;
        }
        return min;
    }
    private static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val) {
            this.val = val;
        }
        private TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
