package codetree.simulation2;

import java.util.*;

public class ConsecutiveArrayOverT {

    private static int n;
    private static int t;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        t = input.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println(findOverTLen());
    }

    private static int findOverTLen() {
        int max = 0;
        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > t) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt > max) {
                max = cnt;
            }
        }

        return max;
    }
}