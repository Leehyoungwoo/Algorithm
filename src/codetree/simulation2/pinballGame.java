package codetree.simulation2;

import java.io.*;
import java.util.*;

public class pinballGame {

    private static final int TYPE_ONE = 1;  ////        /
    private static final int TYPE_TWO = 2;  /////       \
    // 하, 좌, 상, 우
    private static final int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        int answer = findMinTime();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(input.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static int findMinTime() {
        int maxTime = 0;
        for (int i = -1; i <= n; i++) {
            for (int j = -1; j <= n; j++) {
                if (canNotDrop(i, j) || isInRange(i, j)) {
                    continue;
                }
                int time = findEscapeTime(i, j);
                maxTime = Math.max(maxTime, time);
            }
        }

        return maxTime;
    }

    private static boolean isInRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    // 떨어뜨려도 격자 안으로 들어가지 않는 경우
    private static boolean canNotDrop(int row, int col) {
        return row == -1 && col == -1 || row == -1 && col == n
                || row == n && col == -1 || row == n && col == n;
    }

    private static int findEscapeTime(int row, int col) {
        int time = 0;
        int curR = row;
        int curC = col;
        int dir = findDirection(row, col);

        while (true) {
            int nextRow = curR + direction[dir][0];
            int nextCol = curC + direction[dir][1];
            time++;

            if (!isInRange(nextRow, nextCol)) {
                break;
            }

            if (map[nextRow][nextCol] == TYPE_ONE) {
                if (dir == 0) {
                    dir = 1;
                } else if (dir == 1) {
                    dir = 0;
                } else if (dir == 2) {
                    dir = 3;
                } else {
                    dir = 2;
                }
            } else if (map[nextRow][nextCol] == TYPE_TWO) {
                dir = 3 - dir;
            }

            curR = nextRow;
            curC = nextCol;
        }

        return time;
    }

    private static int findDirection(int row, int col) {
        if (row == -1 && 0 <= col && col < n) {
            return 0;
        }
        if (col == n && 0 <= row && row < n) {
            return 1;
        }
        if (row == n && 0 <= col && col < n) {
            return 2;
        } else {
            return 3;
        }
    }
}