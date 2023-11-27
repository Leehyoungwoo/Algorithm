package codetree.intermediateLow.simulation2;

import java.util.*;

public class WhoGotTheFine {

    private static int N;
    private static int M;
    private static int K;
    private static int[] students;
    private static int[] penaltySt;

    public static void main(String[] args) {
        init();
        System.out.print(firstPenalty());
    }

    private static int firstPenalty() {

        for(int i = 0; i < penaltySt.length; i ++) {
            students[penaltySt[i]]++;
            for(int j = 1; j < students.length; j++) {
                if(students[j] != K) {
                    continue;
                }
                return j;
            }
        }
        return -1;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        students = new int[N+1];

        M = input.nextInt();
        penaltySt = new int[M];
        K = input.nextInt();

        for(int i = 0; i < M; i++) {
            penaltySt[i] = input.nextInt();
        }
    }
}
