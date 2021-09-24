package autumn.yingjiao;

public class P2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(2);
        System.out.println(maxHuffman(root));
    }
    public static int maxHuffman (TreeNode root) {
        MyTreeNode parent = MyTreeNode.toMyTreeNode(root);
//        parent.show();
        int max = 0;
        max = maxValue(max, parent.left);
        max = maxValue(max, parent.right);
        return max;
    }
    private static int maxValue(int max, MyTreeNode root) {
        if(root == null) {
            return max;
        }
        if (root.huff) {
            return Math.max(max, root.node);
        } else {
            max = maxValue(max, root.left);
            max = maxValue(max, root.right);
            return max;
        }
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
     }
    static class MyTreeNode {
        int val = 0;
        int node = 1;
        boolean huff = false;
        MyTreeNode left = null;
        MyTreeNode right = null;
        public MyTreeNode(int val) {
            this.val = val;
        }
        private static MyTreeNode toMyTreeNode(TreeNode root) {
            if (root == null) {
                return null;
            }
            MyTreeNode parent = new MyTreeNode(root.val);
            int leftVal = 0, rightVal = 0;
            boolean leftHuff = false, rightHuff = false;
            if (root.left != null) {
                parent.left = toMyTreeNode(root.left);
                parent.node += parent.left.node;
                leftVal = parent.left.val;
                leftHuff = parent.left.huff;
            }
            if (root.right != null) {
                parent.right = toMyTreeNode(root.right);
                parent.node += parent.right.node;
                rightVal = parent.right.val;
                rightHuff = parent.right.huff;
            }
            if (root.left == null && root.right == null) {
                parent.huff = true;
            }
            if (leftHuff && rightHuff && parent.val == leftVal + rightVal) {
                parent.huff = true;
            }
            return parent;
        }
        public String toString() {
            return "{value: " + val + ", node: " + node + ", huff: " + huff + "}";
        }
        public void show() {
            System.out.println(toString());
            if (left != null) {
                left.show();
            }
            if (right != null) {
                right.show();
            }
        }
    }
}
