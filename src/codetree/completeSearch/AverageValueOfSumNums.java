import java.util.*;

public class AverageValueOfSumNums {

    private static int N;
    private static int[] nums;
    private static int[] medium;

    public static void main(String[] args) {
        init();
        System.out.print(answer());
    }

    private static int answer() {
        int cnt = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j <nums.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum+= nums[k];
                }
                double avg = (double) sum / (j - i + 1);

                for(int k = i; k <= j; k++) {
                    if(nums[k] == avg) {
                        cnt++;
                    }
                }
            }
        }
        return cnt - 1;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        nums = new int[N];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
    }
}