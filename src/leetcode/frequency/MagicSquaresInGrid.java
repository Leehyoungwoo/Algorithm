package leetcode.frequency;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numMagicSquaresInside(new int[][]{{10,3,5}, {1,6,11}, {7,9,2}}));
    }

    static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (isMagicSquare(i, j, grid)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isMagicSquare(int r, int c, int[][] grid) {
            if (r + 2 >= grid.length || c + 2 >= grid[0].length) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = r; i <= r + 2; i++) {
                for (int j = c; j <= c + 2; j++) {
                    if (grid[i][j] >= 10 || grid[i][j] <= 0) {
                        return false;
                    }
                    set.add(grid[i][j]);
                }
            }
            if (set.size() != 9) {
                return false;
            }
            int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
            int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
            if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] == sum &&
                    grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] == sum &&
                    grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] == sum &&
                    grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] == sum &&
                    grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] == sum &&
                    grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] == sum &&
                    grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] == sum) {
                return true;
            }
                return false;
        }
    }
}
