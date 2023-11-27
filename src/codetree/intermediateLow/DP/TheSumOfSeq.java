package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheSumOfSeq {

    private static int n;
    private static int m;
    private static int[] num;
    private static int[] dp;
//    private static final int MAX_NUM = 10_000;

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
        num = new int[n];

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = 101;
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                //dp[j]는 합쳐서 j가 되기 위한 부분 수열의 최소 길이
                if (j >= num[i]) {
                    /// j일때 부분 수열은 j-num[i]일때보다 1 더 길다.
                    // 맨 아래로 내려가면 dp[0]이고 dp[num[i]] = 1이된다.
                    dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
                }
            }
        }

        // 최소 길이가 나올 수 있는 최대 길이 + 1에서 갱신되지 않았다면 만들 수 없는거니까 -1
        if (dp[m] == 101) {
            dp[m] = -1;
        }
    }
}
