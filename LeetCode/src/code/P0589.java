package code;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0589 {
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root != null) {
            LinkedList<Node> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                answer.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.add(node.children.get(i));
                    }
                }
            }
        }
        return answer;
    }
}
