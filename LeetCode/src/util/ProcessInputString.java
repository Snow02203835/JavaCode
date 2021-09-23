package util;

public class ProcessInputString {
    public static int[] processVector(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }
        String[] numStr = str.split(",");
        int[] nums = new int[numStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        return nums;
    }
    public static int[][] processMatrix(String str) {
        str = str.substring(2, str.length()-2);
        String[] vector = str.split("],\\[");
        int[][] nums = new int[vector.length][];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = processVector(vector[i]);
        }
        return nums;
    }
//    public static code.P0098.model.TreeNode toTree(String treeStr) {
//        treeStr = treeStr.substring(1, treeStr.length()-1);
//        if (treeStr.equals("") || treeStr.length() == 0) {
//            return null;
//        }
//        String[] nodes = treeStr.split(",");
//        if (nodes.length < 1 || nodes[0].equals("null")) {
//            return null;
//        }
//        code.P0098.model.TreeNode treeNode = new code.P0098.model.TreeNode(Integer.parseInt(nodes[0]));
//        for (int i = 1; i < nodes.length; i++) {
//            int temp = (i*2);
//            if (temp < nodes.length && nodes[temp].equals("null"));
//        }
//        // 1 3 4 2 5 6
//        // 0 1 2 3 4 5 6 7 8
//        return treeNode;
//    }
}
