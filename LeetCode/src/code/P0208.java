package code;

/**
 * 实现Trie(前缀树)
 * @author snow
 * @since 2021/09/24 14:40
 */
public class P0208 {
    public static void main(String[] args) {
        String[] operation = new String[] {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[] value = new String[] {"", "apple", "apple", "app", "app", "app", "app"};
        Trie main = null;
        for (int i = 0; i < operation.length; i++) {
            switch (operation[i]) {
                case "insert" -> main.insert(value[i]);
                case "search" -> System.out.println(main.search(value[i]));
                case "startsWith" -> System.out.println(main.startsWith(value[i]));
                default -> main = new Trie();
            }
        }
    }
    private static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new Node();
                }
                temp = temp.children[index];
            }
            temp.end = true;
        }

        public boolean search(String word) {
            return find(word, false);
        }

        public boolean startsWith(String prefix) {
            return find(prefix, true);
        }

        private boolean find(String word, boolean start) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (temp.children[index] == null) {
                    return false;
                }
                temp = temp.children[index];
            }
            return start || temp.end;
        }

        private static class Node {
            private boolean end;
            private final Node[] children;

            public Node() {
                end = false;
                this.children = new Node[26];
            }
        }
    }
}
