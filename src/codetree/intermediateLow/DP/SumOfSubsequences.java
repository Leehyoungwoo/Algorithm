package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfSubsequences {

    private static int n;
    private static int m;
    private static int[] num;
    private static boolean[] dp;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        num = new int[n];
        dp = new boolean[m + 1];
        Arrays.fill(dp, false);

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void findAnswer() {
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= num[i]; j--) {
                if (dp[j - num[i]]) {
                    dp[j] = true;
                }
            }
        }
    }

    private static void printAnswer() {
        if (dp[m]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
