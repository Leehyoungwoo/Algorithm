package codetree.sort;

import java.util.Scanner;
import java.util.Arrays;

public class GroupByTwo {

    private static final int Max_N = 1000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[2 * Max_N];

        for (int i = 0; i < 2 * N; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr, 0, 2 * N);
        int anwswer = 0;
        for (int i = 0; i < N; i++) {
            int groupSum = arr[i] + arr[2 * N - 1 - i];
            if (groupSum > anwswer) {
                anwswer = groupSum;
            }
        }
        System.out.print(anwswer);
    }
}