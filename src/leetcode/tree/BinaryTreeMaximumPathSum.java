package leetcode.tree;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

    }

    static class Solution {

        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;

            calculateMaxPath(root);
            return maxSum;
        }

        private int calculateMaxPath(TreeNode root) {
            if (root == null) return 0;
            int maxLeft = Math.max(0, calculateMaxPath(root.left));
            int maxRight = Math.max(0, calculateMaxPath(root.right));

            int curMax = root.val + maxLeft + maxRight;
            maxSum = Math.max(maxSum, curMax);

            return root.val + Math.max(maxLeft, maxRight);
        }
    }

    class TreeNode {
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
