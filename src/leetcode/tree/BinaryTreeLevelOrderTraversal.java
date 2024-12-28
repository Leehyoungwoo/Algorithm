package leetcode.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Map<Integer, List<Integer>> map = new HashMap<>();
            fillMap(root, 0, map);
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                res.add(entry.getKey(), entry.getValue());
            }

            return res;
        }

        private void fillMap(TreeNode root, int index, Map<Integer, List<Integer>> map) {
            if (root == null) return;

            map.computeIfAbsent(index, k-> new ArrayList<>()).add(root.val);
            fillMap(root.left, index + 1, map);
            fillMap(root.right, index + 1, map);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
