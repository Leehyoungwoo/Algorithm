import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1194 {

    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        N = Integer.parseInt(input.readLine());
        dp = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i][0] += Math.min(dp[i - 1][1] , dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0] , dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0] , dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}