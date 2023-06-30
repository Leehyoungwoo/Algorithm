package codetree.simulation1;

import java.util.*;

public class PaintBlackAndWhite {

    private static int cur;
    private static char[] tile;
    private static int[] visitedW;
    private static int[] visitedB;

    static {
        cur = 100_000;
        tile = new char[200_001];
        visitedW = new int[200_001];
        visitedB = new int[200_001];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while (n-- > 0) {
            int x = input.nextInt();
            String dir = input.next();
            paint(x, dir);
        }
        printAll();
    }

    private static void printAll() {
        int white = 0;
        int black = 0;
        int gray = 0;

        for (int i = 0; i < 200_001; i++) {
            if (visitedB[i] >= 2 && visitedW[i] >= 2) {
                gray++;
                continue;
            }
            if (tile[i] == 'w') {
                white++;
                continue;
            }
            if (tile[i] == 'b') {
                black++;
            }
        }

        System.out.println(white + " " + black + " " + gray);
    }

    private static void paint(int x, String dir) {
        switch (dir) {
            case "L":
                paintLeft(x);
                return;
            case "R":
                paintRight(x);
                return;
            default:
                throw new RuntimeException("일어날 수 없는 움직임입니다.");
        }
    }

    private static void paintLeft(int x) {
        for (int i = 0; i < x; i++) {
            tile[cur] = 'w';
            visitedW[cur]++;
            cur--;
        }
        cur++;
    }

    private static void paintRight(int x) {
        for (int i = 0; i < x; i++) {
            tile[cur] = 'b';
            visitedB[cur]++;
            cur++;
        }
        cur--;
    }
}