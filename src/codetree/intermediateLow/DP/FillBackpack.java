package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FillBackpack {

    private static int n;
    private static int m;
    private static Jewel[] jewels;
    private static int[] dp;

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
        dp = new int[m + 1];

        jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            jewels[i] = new Jewel(w, v);
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= jewels[i].weight) {
                    dp[j] = Math.max(dp[j], dp[j - jewels[i].weight] + jewels[i].value);
                }
            }
        }
    }

    private static void printAnswer() {
        int idx = 0;
        for (int i = m; i >= 0; i--) {
            if (dp[i] != 0) {
                idx = i;
                break;
            }
        }
        System.out.println(dp[idx]);
    }
}
