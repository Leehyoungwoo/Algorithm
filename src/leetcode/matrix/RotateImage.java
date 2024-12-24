package leetcode.matrix;

public class RotateImage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int[][] newMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    newMatrix[i][j] = matrix[matrix.length - 1 - j][i];
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = newMatrix[i][j];
                }
            }
        }
    }
}
