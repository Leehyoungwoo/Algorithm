package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.*;

public class D2_1954 {

    private static int[][] snail;
    private static int N;
    private static int T;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            boolean[][] visited = new boolean[N][N];
            makeSnail(1, 0, 0, visited);
            System.out.println("#" + tc);
            printSnail();
        }
    }

    private static void makeSnail(int cnt, int curX, int curY, boolean[][] visited) {
        if (cnt == N * N + 1) {
            return;
        }

        snail[curY][curX] = cnt;
        visited[curY][curX] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
                makeSnail(cnt + 1, nextX, nextY, visited);
            }
        }
    }

    private static void printSnail() {
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail[i].length; j++) {
                System.out.print(snail[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void init(Scanner input) {
        N = input.nextInt();
        snail = new int[N][N];
    }
}