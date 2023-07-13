package codetree.completeSearch;

import java.util.*;

public class SingleOperLock {

    private static int N;
    private static int[] nums;

    public static void main(String[] args) {
        init();
        System.out.print(answer());
    }

    private static int answer() {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <=N; j++) {
                for(int k = 1; k <= N; k++) {

                    if(nums[0] - 2 <= i && i <= nums[0] + 2) {
                        cnt++;
                        continue;
                    }
                    if(nums[1] - 2 <= j && j <= nums[1] + 2) {
                        cnt++;
                        continue;

                    }
                    if(nums[2] - 2 <= k && k <= nums[2] + 2) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = input.nextInt();
        }
    }
}