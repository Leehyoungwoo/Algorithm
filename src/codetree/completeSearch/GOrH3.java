package codetree.completeSearch;

import java.util.*;

public class GOrH3 {

    private static int N;
    private static int K;
    private static char[] ch;

    public static void main(String[] args) {
        init();
        System.out.print(getScore());
    }

    private static int getScore() {
        int max = 0;

        for (int i = 1; i < ch.length - K; i++) {
            int score = 0;
            for (int j = i; j <= i + K; j++) {
                if (ch[j] == 'G') {
                    score += 1;
                }
                if (ch[j] == 'H') {
                    score += 2;
                }
            }
            max = Math.max(score, max);
        }

        return max;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        ch = new char[10_001];

        for (int i = 0; i < N; i++) {
            int pos = input.nextInt();
            char alpha = input.next().charAt(0);

            ch[pos] = alpha;
        }
    }
}