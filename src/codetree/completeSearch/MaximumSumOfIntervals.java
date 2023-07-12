package codetree.completeSearch;

import java.util.Scanner;

public class MaximumSumOfIntervals {

    private static int n;
    private static int k;
    private static int[] nums;

    public static void main(String[] args) {
        init();
        System.out.print(findMaxSum());
    }

    private static int findMaxSum() {
        int max = 0;

        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum+=nums[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
    }
}
