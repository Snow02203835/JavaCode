package code;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * @author snow
 * @since 2021/09/24 13:36
 */
public class P0199 {
    public static void main(String[] args) {
        P0199 main = new P0199();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5, new TreeNode(6), null)),
                new TreeNode(3, null, new TreeNode(4)));
        System.out.println(main.rightSideView(root));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> current = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            current.add(root);
            while (!current.isEmpty()) {
                TreeNode temp;
                while (!current.isEmpty()) {
                    temp = current.pollFirst();
                    if (current.isEmpty()) {
                        answer.add(temp.val);
                    }
                    if (temp.left != null) {
                        nextLevel.add(temp.left);
                    }
                    if (temp.right != null) {
                        nextLevel.add(temp.right);
                    }
                }
                LinkedList<TreeNode> swap = current;
                current = nextLevel;
                nextLevel = swap;
            }
        }
        return answer;
    }
}
