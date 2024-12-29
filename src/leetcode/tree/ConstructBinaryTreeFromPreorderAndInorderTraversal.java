package leetcode.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) return null;

            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            int inRootIdx = findIdx(inorder, rootVal, inStart, inEnd);

            int leftTreeSize = inRootIdx - inStart;
            root.left = build(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart, inRootIdx - 1);
            root.right = build(preorder, inorder, preStart + leftTreeSize + 1, preEnd, inRootIdx + 1, inEnd);

            return root;
        }

        private int findIdx(int[] inorder, int rootVal, int inStart, int inEnd) {
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) return i;
            }
            return -1;
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
