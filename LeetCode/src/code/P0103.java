package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> current = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            int level = 0;
            current.add(root);
            while (!current.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!current.isEmpty()) {
                    TreeNode node = current.pollLast();
                    list.add(node.val);
                    if (level%2 == 0) {
                        if (node.left != null) {
                            nextLevel.add(node.left);
                        }
                        if (node.right != null) {
                            nextLevel.add(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            nextLevel.add(node.right);
                        }
                        if (node.left != null) {
                            nextLevel.add(node.left);
                        }
                    }
                }
                answer.add(list);
                level++;
                LinkedList<TreeNode> temp = current;
                current = nextLevel;
                nextLevel = temp;
            }
        }
        return answer;
    }
}
