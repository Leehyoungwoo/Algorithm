package codetree.simulation1;

import java.util.*;

public class AreaOfNonOverlappingRectangles {

    private static int[][] map = new int[2001][2001];
    private static int x1,y1,x2,y2;
    private static int OFFSET = 1000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            x1 = input.nextInt() + OFFSET;
            y1 = input.nextInt() + OFFSET;
            x2 = input.nextInt() + OFFSET;
            y2 = input.nextInt() + OFFSET;

            fillAB();
        }

        for (int i = 0; i < 1; i++) {
            x1 = input.nextInt() + OFFSET;
            y1 = input.nextInt() + OFFSET;
            x2 = input.nextInt() + OFFSET;
            y2 = input.nextInt() + OFFSET;
            fillM();
        }
        System.out.println(Answer());
    }

    private static void fillM() {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j]+=2;
            }
        }
    }

    private static int Answer() {
        int cnt = 0;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if(map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void fillAB() {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j]++;
            }
        }
    }
}
