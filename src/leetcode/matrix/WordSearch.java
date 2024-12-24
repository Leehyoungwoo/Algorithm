package leetcode.matrix;

public class WordSearch {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'a'}, {'a'}}, "aa"));
    }

    static class Solution {

        private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
                return false;
            }

            boolean[][] visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0) && backtrack(i, j, 0, board, visited, word)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean backtrack(int r, int c, int idx, char[][] board, boolean[][] visited, String word) {
            if (idx == word.length()) {
                return true;
            }

            if (!isInRange(r, c, board) || visited[r][c] || board[r][c] != word.charAt(idx)) {
                return false;
            }

            visited[r][c] = true;

            for (int[] dir : direction) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if (backtrack(nextR, nextC, idx + 1, board, visited, word)) {
                    return true;
                }
            }

            visited[r][c] = false;
            return false;
        }

        private boolean isInRange(int r, int c, char[][] board) {
            return 0 <= r && r < board.length && 0 <= c && c < board[0].length;
        }
    }
}
