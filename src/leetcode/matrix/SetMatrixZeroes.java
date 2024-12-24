package leetcode.matrix;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.setZeroes(new int[][] {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        });
    }

    static class Solution {

        private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private boolean[][] visited;

        public void setZeroes(int[][] matrix) {
            visited = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0 && !visited[i][j]) {
                        setting(i, j, matrix);
                    }
                }
            }
        }

        private void setting(int r, int c, int[][] matrix) {
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                while (isInRange(nextR, nextC, matrix)) {
                    if (matrix[nextR][nextC] == 0) {
                        nextR = nextR + dir[0];
                        nextC = nextC + dir[1];
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    matrix[nextR][nextC] = 0;
                    nextR = nextR + dir[0];
                    nextC = nextC + dir[1];
                }
            }
        }

        private boolean isInRange(int r, int c, int[][] matrix) {
            return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
        }
    }
}
