package leetcode.frequency;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInAMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.luckyNumbers(new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        }));
    }

    static class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (isLucky(i, j, matrix)) {
                        res.add(matrix[i][j]);
                    }
                }
            }

            return res;
        }

        private boolean isLucky(int r, int c, int[][] matrix) {
            for (int i = 0; i < matrix[r].length; i++) {
                if (matrix[r][c] > matrix[r][i]) {
                    return false;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[r][c] < matrix[i][c]) {
                    return false;
                }
            }
            return true;
        }
    }
}
