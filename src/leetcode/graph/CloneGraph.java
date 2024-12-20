package leetcode.graph;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) {
        System.out.println();
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;

            Map<Node, Node> map = new HashMap<>();

            return dfs(node, map);
        }

        private Node dfs(Node node, Map<Node, Node> map) {
            if (map.containsKey(node)) {
                return map.get(node);
            }

            Node clone = new Node(node.val);
            map.put(node, clone);

            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(dfs(neighbor, map));
            }

            return clone;
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

