package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementInBST {

    public static void main(String[] args) {

    }

    static class Solution {
        private List<Integer> nodeVals = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            searchTree(root);
            Collections.sort(nodeVals);
            return nodeVals.get(k - 1);
        }

        private void searchTree(TreeNode root) {
            if (root == null) return;
            nodeVals.add(root.val);
            searchTree(root.left);
            searchTree(root.right);
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
