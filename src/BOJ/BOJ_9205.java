package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Position {
    int row;
    int col;

    int beer = 20;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BOJ_9205 {

    private static final int ADJUST = 32_767;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int t;
    private static int n;
    private static List<Position> 편의점들;
    private static Position 상근이집;
    private static Position 축제;
    private static int bear;

    /// 거리 차이는 x좌표의 차이 + y좌표의 차이
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        t = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= t; tc++) {
            init(input);
            String answer = findAnswer();
            builder.append(answer).append("/");
        }

        System.out.println(builder);
    }

    private static void init(BufferedReader input) throws IOException {
        n = Integer.parseInt(input.readLine());
        편의점들 = new ArrayList<>();
        String[] 상근집 = input.readLine().split(" ");
        상근이집 = new Position(Integer.parseInt(상근집[0]) + ADJUST, Integer.parseInt(상근집[1]) + ADJUST);
        bear = 20;
        상근이집.beer = bear;

        for (int i = 0; i < n; i++) {
            String[] 편의점 = input.readLine().split(" ");
            편의점들.add(new Position(Integer.parseInt(편의점[0]) + ADJUST, Integer.parseInt(편의점[1]) + ADJUST));
        }

        String[] 축제임 = input.readLine().split(" ");
        축제 = new Position(Integer.parseInt(축제임[0]) + ADJUST, Integer.parseInt(축제임[1]) + ADJUST);
    }

    private static String findAnswer() {
        boolean canJoin = false;
        Queue<Position> que = new LinkedList<>();
        que.offer(상근이집);
        boolean[][] visited = new boolean[ADJUST * 2 + 1][ADJUST * 2 + 1];

        while (!que.isEmpty()) {
            Position cur = que.poll();
            int curR = cur.row;
            int curC = cur.col;
            int curBeer = cur.beer;

            for (int[] dir : direction) {
                int nextR = curR + dir[0];
                int nextC = curC + dir[1];
                curBeer--;

                for (int i = 0; i < 편의점들.size(); i++) {
                    if (nextR == 편의점들.get(i).row && nextC == 편의점들.get(i).col) {
                        curBeer++;
                    }
                }

                if (nextR == 축제.row && nextC == 축제.col) {
                    canJoin = true;
                    break;
                }

                if (isInRange(nextR, nextC) && !visited[nextR][nextC]) {
                    Position next = new Position(nextR, nextC);
                    next.beer = curBeer;
                    que.offer(next);
                }

                if (curBeer == 0) {
                    break;
                }
            }
        }

        return canJoin ? "happy" : "Sad";
    }

    private static boolean isInRange(int r, int c) {
        return (0 <= r && r <= 32767 * 2) && (0 <= c && c <= 32767 * 2);
    }
}
