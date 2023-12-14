package codetree.intermediateLow.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChooseOne {

    private static int n;
    private static int[] red;
    private static int[] blue;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        System.out.println(Math.max(dp[2*n][n][n], dp[2*n][n][n]));
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        red = new int[2 * n + 1];
        blue = new int[2 * n + 1];
        dp = new int[2*n + 1][n + 1][n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            red[i] = Integer.parseInt(tokenizer.nextToken());
            blue[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void findAnswer() {
        for (int i = 1; i <= 2*n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k] + red[i]);
                    if (k > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1] + blue[i]);
                }
            }
        }
    }
}
