package codetree.simulation1;

import java.util.*;

public class
TotalAreaOfConfetti {

    private static int n;
    private static int[][] map = new int[301][301];
    private static int OFFSET = 100;
    private static int x1, y1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            x1 = input.nextInt() + OFFSET;
            y1 = input.nextInt() + OFFSET;
            confetti();
        }

        System.out.println(answer());
    }

    private static int answer() {
        int cnt = 0;
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 301; j++) {
                if (map[i][j] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void confetti() {
        for (int i = x1; i < x1 + 8; i++) {
            for (int j = y1; j < y1 + 8; j++) {
                map[i][j]++;
            }
        }
    }
}
