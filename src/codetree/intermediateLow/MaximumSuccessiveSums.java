package codetree.intermediateLow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSuccessiveSums {

    private static final int MIN_NUM = -100_000_000;
    private static int n;
    private static int[] num;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dp = new int[n + 1];
        Arrays.fill(dp, MIN_NUM);
    }


    private static void findAnswer() {
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(num[i - 1], dp[i - 1] + num[i - 1]);
        }
    }

    private static void printAnswer() {
        Arrays.sort(dp);
        if(dp[n] == 0) {
            System.out.println(dp[n-1]);
            return;
        }
        System.out.println(dp[n]);
    }
}
