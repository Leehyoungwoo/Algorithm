package forkakao.techInternship2022;

import java.util.*;

public class 코딩_테스트_공부 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[][] problem = {
                {10, 15, 2, 1, 2},
                {20, 20, 3, 3, 4}
        };
        int answer = solution.solution(10, 10, problem);
        System.out.println(answer);
    }
}

class Solution3 {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 150;
        int maxCop = 150;

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        for (int a = alp; a <= maxAlp; a++) {
            for (int c = cop; c <= maxCop; c++) {
                // 공부로 올리는 알고, 코딩력
                if (a + 1 <= maxAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }
                if (c + 1 <= maxCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }
                // 문제로 올리는 알고, 코딩력
                for (int[] problem : problems) {
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    if (a >= alp_req && c >= cop_req) {
                        int newAlp = Math.min(maxAlp, a + alp_rwd);
                        int newCop = Math.min(maxCop, c + cop_rwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[a][c] + cost);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int a = 0; a <= maxAlp; a++) {
            for (int c = 0; c <= maxCop; c++) {
                boolean canSolveAll = true;
                for (int[] problem : problems) {
                    if (a < problem[0] || c < problem[1]) {
                        canSolveAll = false;
                        break;
                    }
                }
                if (canSolveAll) {
                    result = Math.min(result, dp[a][c]);
                }
            }
        }
        return result;
    }
}
