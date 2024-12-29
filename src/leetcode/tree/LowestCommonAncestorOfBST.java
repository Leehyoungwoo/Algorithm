    package leetcode.tree;

    public class LowestCommonAncestorOfBST {

        public static void main(String[] args) {

        }

        static class Solution {
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                while (root != null) {
                    if (root.val > p.val && root.val > q.val) {
                        root = root.left;
                    } else if (root.val < p.val && root.val < q.val) {
                        root = root.right;
                    } else {
                        return root;
                    }
                }

                return root;
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
