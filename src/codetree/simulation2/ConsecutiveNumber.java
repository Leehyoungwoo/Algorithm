package codetree.simulation2;

import java.util.*;

public class ConsecutiveNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        int max = 0;
        int minus = 0;
        int plus = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                minus++;
                plus = 0;
                if (minus > max) {
                    max = minus;
                }
            } else if (arr[i] > 0) {
                plus++;
                minus = 0;
                if (plus > max) {
                    max = plus;
                }
            }
        }
        System.out.println(max);
    }
}
