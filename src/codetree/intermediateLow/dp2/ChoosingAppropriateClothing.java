package codetree.intermediateLow.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Cloth {
    int startDay;
    int endDay;
    int value;

    public Cloth(int startDay, int endDay, int value) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.value = value;
    }
}

public class ChoosingAppropriateClothing {

    private static int n;
    private static int m;
    private static Cloth[] cloths;
    private static int[][] dp;

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
        cloths = new Cloth[n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            cloths[i] = new Cloth(start, end, value);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i] = 0;
        }
    }

    private static void findAnswer() {
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cloths[j].startDay > i || cloths[j].endDay < i) {
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if(cloths[k].startDay > i - 1 || cloths[k].endDay < i - 1) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(cloths[j].value - cloths[k].value));
                }
            }
        }
    }

    private static void printAnswer() {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[m][i]);
        }

        System.out.println(ans);
    }
}
