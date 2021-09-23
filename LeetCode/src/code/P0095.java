package code;

import java.util.ArrayList;
import java.util.List;

public class P0095 {
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> answerList = new ArrayList<>(n);
        List<TreeNode> tree = new ArrayList<>(1);
        tree.add(null);
        answerList.add(tree);
        tree = new ArrayList<>(1);

        return answerList.get(n);
    }
    private static class TreeNode {
        private int val;
        private int left;
        private int right;
    }
}
