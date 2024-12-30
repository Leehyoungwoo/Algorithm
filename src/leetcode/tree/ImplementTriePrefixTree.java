package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {

    public static void main(String[] args) {

    }

    static class Trie {

        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node node = this.root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
            }
            node.endOfWord = true;
        }

        public boolean search(String word) {
            Node node = this.root;

            for (int i = 0; i < word.length(); i++) {
                node = node.children.getOrDefault(word.charAt(i), null);
                if (node == null) {
                    return false;
                }
            }

            return node.endOfWord;
        }

        public boolean startsWith(String prefix) {
            Node node = this.root;

            for (int i = 0; i < prefix.length(); i++) {
                node = node.children.getOrDefault(prefix.charAt(i), null);
                if (node == null) {
                    return false;
                }
            }

            return true;
        }
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord;

        public Node() {
        }
    }
}
