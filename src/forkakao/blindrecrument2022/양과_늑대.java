package forkakao.blindrecrument2022;

import java.util.*;
import java.util.Arrays;

public class 양과_늑대 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int[][] edges = {
                {0, 1},
                {1, 2},
                {1, 4},
                {0, 8},
                {8, 7},
                {9, 10},
                {9, 11},
                {4, 3},
                {6, 5},
                {4, 6},
                {8, 9}
        };
        int answer = solution.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, edges);
        System.out.println(answer);
    }
}

class Solution5 {

    private int maxSheep = Integer.MIN_VALUE;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        // Dfs로 찾으면 되지 않을까?
        findMaxSheep(0, info, 0, 0, new boolean[n], edges);
        return maxSheep;
    }

    private void findMaxSheep(int cur, int[] info, int sheep, int wolf, boolean[] visited, int[][] edge) {
        boolean[] nextVisited = visited.clone();
        nextVisited[cur] = true;

        if (info[cur] == 0) {
            sheep++;
            maxSheep = Math.max(maxSheep, sheep);
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        for (int[] e : edge) {
            if (nextVisited[e[0]] && !nextVisited[e[1]]) {
                findMaxSheep(e[1], info, sheep, wolf, nextVisited, edge);
            }
        }
    }
}