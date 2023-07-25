package BOJ;

import java.util.*;

public class BOJ_2559 {

    private static int[] degrees;
    private static int N;
    private static int K;

    public static void main(String[] args) {
        init();
        int answer = findMaxSum();
        System.out.println(answer);
    }

    private static int findMaxSum() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= degrees.length - K; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum+= degrees[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        degrees = new int[N];

        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = input.nextInt();
        }
    }
}