package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder serialized = new StringBuilder();
            serializeHelper(root, serialized);
            return serialized.toString();
        }

        private void serializeHelper(TreeNode root, StringBuilder serialized) {
            if (root == null) {
                serialized.append("null,");
                return;
            }

            serialized.append(root.val + ",");
            serializeHelper(root.left, serialized);
            serializeHelper(root.right, serialized);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {
            String value = queue.poll();
            if (value.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(value));
            root.left = deserializeHelper(queue);
            root.right = deserializeHelper(queue);
            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
