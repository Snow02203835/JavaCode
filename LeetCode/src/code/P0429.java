package code;

import model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0429 {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        if (root != null) {
            current.add(root);
            while (!current.isEmpty()) {
                List<Integer> group = new ArrayList<>();
                while (!current.isEmpty()) {
                    Node temp = current.pollFirst();
                    if (temp != null) {
                        group.add(temp.val);
                        nextLevel.addAll(temp.children);
                    }
                }
                answer.add(group);
                LinkedList<Node> temp = current;
                current = nextLevel;
                nextLevel = temp;
            }
        }
        return answer;
    }
}
