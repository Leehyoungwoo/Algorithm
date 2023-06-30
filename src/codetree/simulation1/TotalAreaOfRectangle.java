package codetree.simulation1;

import java.util.*;

public class TotalAreaOfRectangle {

    private static int n;
    private static int[][] map;
    private static int x1, y1, x2, y2;
    private static int[] arr;
    private static int OFF_SET = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        map = new int[201][201];

        for (int i = 0; i < n; i++) {
            x1 = input.nextInt() + OFF_SET;
            y1 = input.nextInt() + OFF_SET;
            x2 = input.nextInt() + OFF_SET;
            y2 = input.nextInt() + OFF_SET;

            fillArea();
        }
        System.out.println(countFill());
    }

    private static int countFill() {
        int cnt = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (map[i][j] > 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void fillArea() {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j]++;
            }
        }
    }
}
