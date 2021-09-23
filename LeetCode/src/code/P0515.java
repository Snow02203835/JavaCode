package code;

import model.TreeNode;

import java.util.*;

public class P0515 {
    public static void main(String[] args) {

    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.addLast(root);
        while (!currentLevel.isEmpty()) {
            int max = 0;
            while (!currentLevel.isEmpty()) {
                TreeNode temp = currentLevel.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    nextLevel.addLast(temp.left);
                }
                if (temp.right != null) {
                    nextLevel.addLast(temp.right);
                }
            }
            answer.add(max);
            LinkedList<TreeNode> tempQueue = currentLevel;
            currentLevel = nextLevel;
            nextLevel = tempQueue;
        }
        return answer;
    }
}