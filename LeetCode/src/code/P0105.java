package code;

public class P0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode tree = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                if (i != 0) {
                    tree.left = buildTree(subArray(preorder, 1, 1+i), subArray(inorder, 0, i));
                }
                if (i < inorder.length-1) {
                    tree.right = buildTree(subArray(preorder, 1+i, preorder.length), subArray(inorder, i+1, inorder.length));
                }
            }
        }
        return tree;
    }
    private int[] subArray(int[] arr, int start, int end) {
        if (start == 0 && end == arr.length) {
            return arr;
        }
        end = Math.min(end, arr.length);
        int[] newArr = new int[end-start];
        System.arraycopy(arr, start, newArr, 0, end-start);
        return newArr;
    }
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val) {
            this.val = val;
        }
    }
}
