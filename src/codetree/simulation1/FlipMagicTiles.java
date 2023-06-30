package codetree.simulation1;

import java.util.*;

public class FlipMagicTiles {

    private static int cur;
    private static char[] tile;
    private static int[] visited;

    static {
        cur = 100_000;
        tile = new char[200_001];
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
        System.out.println(cntWhite() + " " + cntBlack());
    }

    private static int cntWhite() {
        int cnt = 0;
        for (int i = 0; i < tile.length; i++) {
            if (tile[i] == 'w') {
                cnt++;
            }
        }
        return cnt;
    }

    private static int cntBlack() {
        int cnt = 0;
        for (int i = 0; i < tile.length; i++) {
            if (tile[i] == 'b') {
                cnt++;
            }
        }
        return cnt;
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
            cur--;
        }
        cur++;
    }

    private static void paintRight(int x) {
        for (int i = 0; i < x; i++) {
            tile[cur] = 'b';
            cur++;
        }
        cur--;
    }
}