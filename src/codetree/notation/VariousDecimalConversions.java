package codetree.notation;

import java.util.*;

public class VariousDecimalConversions {

    private static int N;
    private static int B;
    private static int[] arr;

    private static int cnt;

    public static void main(String[] args) {
        init();
        convertToBDecimal();
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    private static void convertToBDecimal() {
        cnt = 0;

        while (true) {
            if(N < B) {
                arr[cnt++] = N;
                break;
            }
            arr[cnt++] = N % B;
            N /= B;
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        B = input.nextInt();
        arr = new int[30];
    }
}
