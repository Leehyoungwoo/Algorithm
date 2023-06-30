package codetree.simulation2;

import java.util.*;

public class ConsecutiveNumber4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        int max = 1;
        int cur = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                cur++;
                if (cur > max) {
                    max = cur;
                }
            } else {
                cur = 1;
            }
        }
        System.out.println(max);
    }
}
