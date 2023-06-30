package codetree.simulation1;

import java.util.*;

public class RectanglesThatOverlap {

    private static int n;
    private static char[][] map = new char[201][201];
    private static int x1, y1, x2, y2;
    private static int OFFSET = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            x1 = input.nextInt() + OFFSET;
            y1 = input.nextInt() + OFFSET;
            x2 = input.nextInt() + OFFSET;
            y2 = input.nextInt() + OFFSET;

            fillMap(i);
        }
        System.out.println(countBlue());
    }

    private static int countBlue() {
        int cnt = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (map[i][j] == 'b') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void fillMap(int n) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (n % 2 == 0) {
                    map[i][j] = 'r';
                } else {
                    map[i][j] = 'b';
                }
            }
        }
    }
}
