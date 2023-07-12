package codetree.completeSearch;

import java.util.*;

public class SumCloseToSpecificNumber {

    private static int N;
    private static int S;
    private static int[] nums;

    public static void main(String[] args) {
        init();
        System.out.print(findSNum());
    }

    private static int findSNum() {
        int sum = totalSum();
        int min = 10_000;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int exNum =  nums[i] + nums[j];
                int thatNum = sum - exNum;
                min = Math.min(getAbs(thatNum -S ), getAbs(min));

            }
        }
        return min;
    }

    private static int getAbs(int n) {
        return Math.abs(n);
    }

    private static int totalSum() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        S = input.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = input.nextInt();
        }
    }
}
