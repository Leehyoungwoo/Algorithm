package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    static class Solution {

        private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private boolean[][] visited;

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            visited = new boolean[matrix.length][matrix[0].length];
            fillList(res, matrix);
            return res;
        }

        private void fillList(List<Integer> res, int[][] matrix) {
            int count = matrix.length * matrix[0].length;
            int r = 0;
            int c = 0;
            int d = 0;
            while (count-- > 0) {
                visited[r][c] =true;
                res.add(matrix[r][c]);
                if (isInRange(r + directions[d][0], c + directions[d][1], matrix) && !visited[r + directions[d][0]][c + directions[d][1]]) {
                    r += directions[d][0];
                    c += directions[d][1];
                } else {
                    d = (d + 1) % 4;
                    r += directions[d][0];
                    c += directions[d][1];
                }
            }
        }

        private boolean isInRange(int r, int c, int[][] matrix) {
            return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
        }
    }
}
