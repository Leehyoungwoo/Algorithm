package swExpertAcademy.algorithmTrackD2;

import java.util.*;

public class TwoStringsOfNums {

    private static int T;
    private static int N;
    private static int M;
    private static int[] A;
    private static int[] B;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        for (int t = 0; t < T; t++) {
            N = input.nextInt();
            M = input.nextInt();
            A = new int[N];
            B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = input.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = input.nextInt();
            }
            int answer = findMaxMultiple();
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    private static int findMaxMultiple() {
        int answer = 0;
        if (AIsBig()) {
            answer = movingB();
        } else {
            answer = movingA();
        }
        return answer;
    }

    private static int movingA() {
        int max = 0;

        for (int i = 0; i < B.length - A.length + 1; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                int mul = A[j] * B[i + j];
                sum += mul;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private static int movingB() {
        int max = 0;

        for (int i = 0; i < A.length - B.length + 1; i++) {
            int sum = 0;
            for (int j = 0; j < B.length; j++) {
                int mul = A[i + j] * B[j];
                sum += mul;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private static boolean AIsBig() {
        return A.length > B.length;
    }
}
