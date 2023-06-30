package swExpertAcademy.algorithmTrackD2;

import java.util.*;

public class flyRepellent3 {

    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int t = 0; t < T; t++) {
            n = input.nextInt();
            m = input.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = input.nextInt();
                }
            }
            System.out.println("#" + (t + 1) + " " + killFly());
        }
    }

    private static int killFly() {
        return Math.max(xShape(), plusShape());
    }

    private static int plusShape() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = plusKilling(i, j);

                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static int plusKilling(int x, int y) {
        int sum = map[x][y];
        for (int i = 1; i < m; i++) {
            if (isValidNum(x, y - i)) {
                sum += map[x][y - i];
            }

            if (isValidNum(x, y + i)) {
                sum += map[x][y + i];
            }

            if (isValidNum(x - i, y)) {
                sum += map[x - i][y];
            }

            if (isValidNum(x + i, y)) {
                sum += map[x + i][y];
            }

        }
        return sum;
    }

    private static int xShape() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = xKilling(i, j);
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static int xKilling(int x, int y) {
        int sum = map[x][y];
        for (int i = 1; i < m; i++) {
            if (isValidNum(x - i, y - i)) {
                sum += map[x - i][y - i];
            }

            if (isValidNum(x + i, y + i)) {
                sum += map[x + i][y + i];
            }

            if (isValidNum(x - i, y + i)) {
                sum += map[x - i][y + i];
            }
            if (isValidNum(x + i, y - i)) {
                sum += map[x + i][y - i];
            }

        }

        return sum;
    }

    private static boolean isValidNum(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}
