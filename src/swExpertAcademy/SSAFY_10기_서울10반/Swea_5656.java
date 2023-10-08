package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_5656 {

    private static int T;
    private static int N;
    private static int W;
    private static int H;
    private static int[][] map;
    private static int minLeft;
    private static int[] per;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            findAnswer(0);
            answer.append("#").append(tc).append(' ').append(minLeft).append("\n");
        }
        System.out.println(answer);
    }

    private static void init(BufferedReader input) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        W = Integer.parseInt(tokenizer.nextToken());
        H = Integer.parseInt(tokenizer.nextToken());
        minLeft = Integer.MAX_VALUE;
        per = new int[N];

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static void findAnswer(int idx) {
        if (idx == N) {
            int left = findLeftBricks(copyMap());
            minLeft = Math.min(minLeft, left);
            return;
        }

        for (int i = 0; i < W; i++) {
            per[idx] = i;
            findAnswer(idx + 1);
        }
    }

    private static int[][] copyMap() {
        int[][] temp = new int[H][W];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

    private static int findLeftBricks(int[][] temp) {
        for (int num : per) {
            shoot(temp, num);
            down(temp);
        }

        return W * H - (int) Arrays.deepToString(temp).chars().filter(ch -> ch == '0').count();
    }

    private static void shoot(int[][] temp, int col) {
        for (int i = 0; i < H; i++) {
            if (temp[i][col] == 0) {
                continue;
            }
            boom(temp, i, col);
            break;
        }
    }

    private static void boom(int[][] temp, int row, int col) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] arr = new int[]{row, col, temp[row][col]};
        boolean[][] visited = new boolean[H][W];
        Queue<int[]> que = new LinkedList<>();
        que.add(arr);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curRange = cur[2];

            for (int[] dir : direction) {
                for (int i = 1; i <= curRange; i++) {
                    int nextR = curR + dir[0] * (i - 1);
                    int nextC = curC + dir[1] * (i - 1);
                    if (isInRange(nextR, nextC) && !visited[nextR][nextC]) {
                        que.add(new int[]{nextR, nextC, temp[nextR][nextC]});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        changeVisitedToZero(temp, visited);
    }

    private static void changeVisitedToZero(int[][] temp, boolean[][] visited) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j]) {
                    temp[i][j] = 0;
                }
            }
        }
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

    private static void down(int[][] temp) {
        for (int i = 0; i < W; i++) {
            int idx = H - 1;
            int[] tem = new int[H];
            for (int j = H - 1; j >= 0; j--) {
                if (temp[j][i] != 0) {
                    tem[idx] = temp[j][i];
                    idx--;
                }
            }
            for (int j = H - 1; j >= 0; j--) {
                temp[j][i] = tem[j];
            }
        }
    }
}
