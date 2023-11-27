package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingCoins {

    private static int n;
    private static int m;
    private static int[] coinTypes;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        System.out.println(dp[m]);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        coinTypes = new int[n];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            coinTypes[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = 10_000;
        }
    }

    private static void findAnswer() {
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coinTypes[j]) {
                    dp[i]  = Math.min(dp[i], dp[i - coinTypes[j]] + 1);
                }
            }
        }
        if (dp[m] == 10_000) {
           dp[m] = -1;
        }
    }
}
