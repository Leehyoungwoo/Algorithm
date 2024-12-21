package leetcode.graph;

import java.util.*;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    static class Solution {

        private final int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] height) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < height[i].length; j++) {
                    if (canFlowPacific(i, j, height) && canFlowAtlantic(i, j, height)) {
                        res.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }

            return res;
        }

        private boolean canFlowPacific(int r, int c, int[][] height) {
            Queue<int[]> que = new LinkedList<>();
            boolean[][] visited = new boolean[height.length][height[0].length];
            que.add(new int[]{r, c});
            visited[r][c] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int curR = cur[0];
                int curC = cur[1];
                if (curR == 0 || curC == 0) {
                    return true;
                }
                for (int[] dir : direction) {
                    int nextR = curR + dir[0];
                    int nextC = curC + dir[1];
                    if (isInRange(nextR, nextC, height) && !visited[nextR][nextC] && height[curR][curC] >= height[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        que.add(new int[] {nextR, nextC});
                    }
                }
            }

            return false;
        }

        private boolean canFlowAtlantic(int r, int c, int[][] height) {
            Queue<int[]> que = new LinkedList<>();
            boolean[][] visited = new boolean[height.length][height[0].length];
            que.add(new int[]{r, c});
            visited[r][c] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                int curR = cur[0];
                int curC = cur[1];
                if (curR == height.length - 1 || curC == height[0].length - 1) {
                    return true;
                }
                for (int[] dir : direction) {
                    int nextR = curR + dir[0];
                    int nextC = curC + dir[1];
                    if (isInRange(nextR, nextC, height) && !visited[nextR][nextC] && height[curR][curC] >= height[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        que.add(new int[] {nextR, nextC});
                    }
                }
            }

            return false;
        }

        private boolean isInRange(int r, int c, int[][] height) {
            return 0 <= r && r <height.length && 0 <= c && c < height[0].length;
        }
    }
}
