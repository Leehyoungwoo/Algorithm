package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumCoinReturn {

    private static int n;
    private static int m;
    private static int[] coins;
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
        dp = new int[m + 1];
        Arrays.fill(dp, -1); // -1로 초기화

        tokenizer = new StringTokenizer(input.readLine());
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void findAnswer() {
        dp[0] = 0; // 0원을 만들 때는 동전을 사용하지 않아도 되므로 0으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (dp[j - coins[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
    }
}
