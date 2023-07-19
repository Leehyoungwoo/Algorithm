package BOJ;

import java.util.*;

public class BOJ_10431 {

    private static int P;
    private static int[] students;
    private static int[] aws;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        P = input.nextInt();
        students = new int[21];
        aws = new int[P];

        for (int t = 0; t < P; t++) {
            for (int i = 0; i < students.length; i++) {
                students[i] = input.nextInt();
            }
            aws[t] = answer();
        }

        for (int i = 0; i < P; i++) {
            System.out.println((i+1) + " " +aws[i]);
        }
    }

    private static int answer() {
        int cnt = 0;

        for (int i = 1; i < students.length; i++) {
            for (int j = 1; j <= i; j++) {
                if(students[j] > students[i]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
