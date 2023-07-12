package codetree.completeSearch;

import java.util.*;

public class LetsGetTogether {

    private static int n;
    private static int[] A;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        A = new int[n+1];

        for(int i = 1; i< A.length; i++) {
            A[i] = input.nextInt();
        }
        System.out.print(findMinSum());
    }

    private static int findMinSum() {
        int min = 0;

        for (int i = 1; i < A.length; i++) {
            min = min + Math.abs((i - 1) * A[i]);
        }


        for(int i = 2; i < A.length; i++) {
            int sum = 0;
            for(int j = 1; j < A.length; j++) {
                sum = sum + Math.abs((j - i) * (A[j]));
            }
            if(sum < min) {
                min = sum;
            }
        }

        return min;
    }
}