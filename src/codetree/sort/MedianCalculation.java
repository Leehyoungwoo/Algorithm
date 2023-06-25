package codetree.sort;

import java.util.Scanner;
import java.util.Arrays;

public class MedianCalculation {

    private static int[] arr;
    private static int[] mid;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        arr = new int[n];
        mid = new int[n / 2 + 1];
        int midIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        findMid(midIndex);
        Arrays.sort(mid);
        printMid();
    }

    private static void printMid() {
        for (int i = 0; i < mid.length; i++) {
            System.out.print(mid[i] + " ");
        }
    }

    private static void findMid(int midIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (isIndexOdd(i)) {
                int[] subArr = Arrays.copyOfRange(arr, 0, i + 1);
                Arrays.sort(subArr);
                mid[midIndex] = subArr[i/2];
                midIndex++;
            }
        }
    }

    private static boolean isIndexOdd(int i) {
        if ((i + 1) % 2 == 1) {
            return true;
        }
        return false;
    }
}
