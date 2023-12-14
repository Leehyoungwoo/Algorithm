package codetree.intermediateLow.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringMatching {

    private static String a;
    private static String b;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        System.out.println(dp[a.length()][b.length()]);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        a = input.readLine();
        b = input.readLine();
        dp = new int[a.length() + 1][b.length() + 1];
    }

    private static void findAnswer() {
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
