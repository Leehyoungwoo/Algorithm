package forkakao.blindrecrument2022;

import java.util.*;

public class 파괴되지_않은_건물 {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[][] board = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}
        };
        int[][] skills = {
                {1, 0, 0, 3, 4, 4},
                {1, 2, 0, 2, 3, 2},
                {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}
        };
        int answer = solution6.solution(board, skills);
        System.out.println(answer == 10);
    }
}

class Solution6 {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] damage = new int[n + 1][m + 1];

        for (int i = 0; i < skill.length; i++) {
            int t = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            // 공격
            if (t == 1) {
                damage[r1][c1] -= degree;
                damage[r1][c2 + 1] += degree;
                damage[r2 + 1][c1] += degree;
                damage[r2 + 1][c2 + 1] -= degree;
            }
            // 회복
            if (t == 2) {
                damage[r1][c1] += degree;
                damage[r1][c2 + 1] -= degree;
                damage[r2 + 1][c1] -= degree;
                damage[r2 + 1][c2 + 1] += degree;
            }
        }
        for (int i = 0; i < damage.length; i++) {
            for (int j = 1; j < damage[0].length; j++) {
                damage[i][j] += damage[i][j - 1];
            }
        }

        // 열 기준 누적합
        for (int j = 0; j < damage[0].length; j++) {
            for (int i = 1; i < damage.length; i++) {
                damage[i][j] += damage[i - 1][j];
            }
        }

        // 계산
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += damage[i][j];
                if (board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}