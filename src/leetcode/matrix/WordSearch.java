package leetcode.matrix;

public class WordSearch {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][] {{'a'}, {'a'}}, "aa"));
    }

    static class Solution {

        private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            if (board.length * board[0].length < word.length()) return false;
            boolean[][] visited = new boolean[board.length][board[0].length];
            int start = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (start != board[i][j]) {
                        continue;
                    }

                    if (allMatch(i, j, 0, board, visited, word)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean allMatch(int r, int c, int idx, char[][] board, boolean[][] visited, String word) {
            if (board.length * board[0].length == 1) {
                if (board[0][0] == word.charAt(0)) {
                    return true;
                }
            }
            if (idx == word.length() - 1 && board[r][c] == word.charAt(idx)) {
                return true;
            }
            visited[r][c] = true;
            for (int[] dir : direction) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if (isInRange(nextR, nextC, visited)
                        && board[r][c] == word.charAt(idx)
                && !visited[nextR][nextC]
                && allMatch(nextR, nextC, idx + 1, board, visited, word)) {
                    return true;
                }
            }
            visited[r][c] = false;
            return false;
        }

        private boolean isInRange(int r, int c, boolean[][] visited) {
            return 0 <= r && r < visited.length && 0 <= c && c < visited[0].length;
        }
    }
}
