package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

    private static int N;
    private static int[][] W;
    private static int minCost;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, new boolean[N], W[0][0], 1);
        System.out.println(minCost);
    }

    private static void dfs(int cur, boolean[] visited, int sum, int cnt) {
        if (cnt == N) {
            if(W[cur][0] != 0) {
                int cost = sum + W[cur][0];
                minCost = Math.min(minCost, cost);
                return;
            }

            return;
        }

        cnt++;

        for (int i = 1; i < N; i++) {
            if (!visited[i] && W[cur][i] != 0) {
                visited[i] = true;
                int newSum = sum + W[cur][i];
                dfs(i, visited, newSum, cnt);
                visited[i] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        minCost = Integer.MAX_VALUE;

        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}
