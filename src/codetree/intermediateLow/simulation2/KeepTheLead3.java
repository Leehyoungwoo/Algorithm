package codetree.intermediateLow.simulation2;

import java.util.*;

public class KeepTheLead3 {

    private static int N;
    private static int M;
    private static int[] A;	// A가 총 이동한 거리
    private static int[] B;	// B가 총 이동한 거리
    private static int RANGE = 1_000_000;
    private static int ACur = 1;
    private static int BCur = 1;

    public static void main(String[] args) {
        init();
        System.out.print(countHOF());
    }

    private static int countHOF() {
        int cnt = 0;
        int HOF = 0;

        for (int i = 1; i < A.length; i++) {
            if(A[i] > B[i]) {
                if(HOF == 2 || HOF == 3) {
                    cnt ++;
                }
                HOF = 1;
                continue;
            }

            if(A[i] < B[i]) {
                if(HOF == 1 || HOF == 3) {
                    cnt++;
                }
                HOF = 2;
                continue;
            }

            if(A[i] == B[i]) {
                if(HOF == 1 || HOF == 2) {
                    cnt++;
                }
                HOF = 3;
            }
        }

        return cnt;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        A = new int[RANGE + 1];
        B = new int[RANGE + 1];

        for(int i = 0; i < N; i++) {
            int v = input.nextInt();
            int t = input.nextInt();
            fillA(v, t);
        }

        for(int i = 0; i < M; i++) {
            int v = input.nextInt();
            int t = input.nextInt();
            fillB(v, t);
        }
    }

    private static void fillA(int v, int t) {
        while (t-- > 0) {
            A[ACur] = A[ACur - 1] + v;
            ACur++;
        }
    }

    private static void fillB(int v, int t) {
        while (t-- > 0) {
            B[BCur] = B[BCur - 1] + v;
            BCur++;
        }
    }

}