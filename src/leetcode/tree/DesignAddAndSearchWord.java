package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWord {

    public static void main(String[] args) {

    }

    static class WordDictionary {

        Node root = new Node();

        public WordDictionary() {

        }

        public void addWord(String word) {
            Node node = this.root;

            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
            }

            node.endOfWord = true;
        }

        public boolean search(String word) {
            return searchHelper(word, root, 0);
        }

        private boolean searchHelper(String word, Node node, int index) {
            if (index == word.length()) {
                return node.endOfWord;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (Node child : node.children.values()) {
                    if (searchHelper(word, child, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                Node child = node.children.get(c);
                if (child == null) {
                    return false;
                }
                return searchHelper(word, child, index + 1);
            }
        }
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord;

        public Node() {
        }
    }
}
