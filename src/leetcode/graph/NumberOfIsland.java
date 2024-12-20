package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numIslands(new char[][]{}));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        bfs(grid, visited, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void bfs(char[][] grid, boolean[][] visited, int r, int c) {
            final int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{r, c});
            visited[r][c] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int curR = cur[0];
                int curC = cur[1];
                for (int[] dir : direction) {
                    int nextR = curR + dir[0];
                    int nextC = curC + dir[1];
                    if (isInRnage(nextR, nextC, grid) && grid[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        que.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }

        private boolean isInRnage(int r, int c, char[][] grid) {
            return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
        }
    }
}
