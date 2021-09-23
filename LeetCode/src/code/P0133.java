package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P0133 {
    // Definition for a model.Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        P0133 main = new P0133();
        main.cloneGraph(n1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>(128);
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        clone(node, copy, map);
        return copy;
    }

    private void clone(Node node, Node copy, HashMap<Integer, Node> map) {
        for (Node connect : node.neighbors) {
            if (isConnected(copy, connect.val)) {
                continue;
            }
            Node newNode = map.get(connect.val);
            if (newNode == null) {
                newNode = new Node(connect.val);
                map.put(connect.val, newNode);
            }
            copy.neighbors.add(newNode);
            clone(connect, newNode, map);
        }
    }

    private boolean isConnected(Node copy, int val) {
        for (Node neighbor : copy.neighbors) {
            if (neighbor.val == val) {
                return true;
            }
        }
        return false;
    }
}
