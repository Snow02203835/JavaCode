package model;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree main = new BinaryTree();
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(main.serialize(main.deserialize("[,1,2,null,null,3,null,null]")));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        prevOrder(builder, root);
        builder.append(']');
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] orders = data.substring(2, data.length()-1).split(",");
        TreeNode root = buildTreeNode(orders[0]);
        if (root != null) {
            buildTree(root, orders, 1);
        }
        return root;
    }

    private int buildTree(TreeNode root, String[] strings, int next) {
        if (next < strings.length) {
            root.left = buildTreeNode(strings[next++]);
            if (root.left != null) {
                next = buildTree(root.left, strings, next);
            }
            root.right = buildTreeNode(strings[next++]);
            if (root.right != null) {
                next = buildTree(root.right, strings, next);
            }
            return next;
        }
        return strings.length-1;
    }

    private TreeNode buildTreeNode(String str) {
        if ("null".equals(str)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(str));
        }
    }

    private void prevOrder(StringBuilder builder, TreeNode root) {
        if (root == null) {
            builder.append(',').append("null");
            return;
        }
        builder.append(',').append(root.val);
        prevOrder(builder, root.left);
        prevOrder(builder, root.right);
    }

}
