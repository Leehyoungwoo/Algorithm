package BOJ;

import java.util.*;

public class BOJ_2798 {

    private static int n;
    private static int m;
    private static int[] card;

    public static void main(String[] args) {
        init();
        System.out.print(answer());
    }

    private static int answer() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < card.length - 2; i++) {
            for (int j = i + 1; j < card.length - 1; j++) {
                for (int k = j + 1; k < card.length; k++) {
                    int sum = m - card[i] - card[j] - card[k];

                    if(sum < 0) {
                        continue;
                    }

                    min = Math.min(min, sum);
                }
            }
        }

        return m - min;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        card = new int[n];

        for (int i = 0; i < n; i++) {
            card[i] = input.nextInt();
        }
    }
}