package BOJ;

import java.util.*;

public class BOJ_10157 {

    private static int c;
    private static int r;
    private static int k;
    private static int[][] map;

    public static void main(String[] args) {
        init();
        isOverseatPeople();
        seatingPeople();
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    System.out.println((j + 1) + " " + (i + 1));
                }
            }
        }

    }

    private static void seatingPeople() {
        int x = 0;
        int y = 0;
        char curDir = 'N';

        while (k-- > 0) {
            map[y][x] = k + 1;

            if (isInWall(x, y, curDir) || visited(x, y, curDir)) {
                curDir = changeDir(curDir);
            }

            x = movingX(x, curDir);
            y = movingY(y, curDir);

        }
    }

    private static boolean visited(int x, int y, char curDir) {
        int nextX = movingX(x, curDir);
        int nextY = movingY(y, curDir);

        if (map[nextY][nextX] != 0) {
            return true;
        }
        return false;
    }

    private static boolean isInWall(int x, int y, char curDir) {
        int nextX = movingX(x, curDir);
        int nextY = movingY(y, curDir);

        if (!isXInRange(nextX) || !isYInRange(nextY)) {
            return true;
        }
        return false;
    }

    private static boolean isXInRange(int nextX) {
        return 0 <= nextX && nextX < c;
    }

    private static boolean isYInRange(int nextY) {
        return 0<= nextY && nextY < r;
    }

    private static int movingX(int x, char curDir) {
        if (curDir == 'E') {
            x++;
        }

        if (curDir == 'W') {
            x--;
        }

        return x;
    }

    private static int movingY(int y, char curDir) {
        if (curDir == 'S') {
            y--;
        }

        if (curDir == 'N') {
            y++;
        }

        return y;
    }

    private static char changeDir(char curDir) {
        if (curDir == 'E') {
            return 'S';
        }

        if (curDir == 'W') {
            return 'N';
        }

        if (curDir == 'S') {
            return 'W';
        }

        if (curDir == 'N') {
            return 'E';
        }

        return curDir;
    }

    private static void isOverseatPeople() {
        if (isTooBigK()) {
            System.out.println(0);
            System.exit(0);
        }
    }

    private static boolean isTooBigK() {
        return c * r < k;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        c = input.nextInt();
        r = input.nextInt();
        k = input.nextInt();
        map = new int[r][c];
    }
}