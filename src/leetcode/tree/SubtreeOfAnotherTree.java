package leetcode.tree;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return subRoot == null;

            if (isSameTree(root, subRoot)) return true;

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return (p.val == q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
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