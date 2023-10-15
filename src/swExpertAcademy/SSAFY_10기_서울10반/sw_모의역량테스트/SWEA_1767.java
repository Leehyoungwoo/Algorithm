package swExpertAcademy.SSAFY_10기_서울10반.sw_모의역량테스트;

import java.io.*;
import java.util.*;

public class SWEA_1767 {

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static final int WIRE = 2;
    private static int T;
    private static int N;
    private static int[][] map;
    private static int wireCnt;
    private static int maxCore;
    private static int minWire;
    private static List<int[]> cores;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            findAnswer(0, maxCore, 0);
            builder.append("#").append(tc).append(" ").append(minWire).append("\n");
        }

        System.out.println(builder);
    }

    private static void init(BufferedReader input) throws IOException {
        N = Integer.parseInt(input.readLine());
        maxCore = 0;
        minWire = Integer.MAX_VALUE;
        wireCnt = 0;
        cores = new ArrayList<>();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 1 && isConneted(i, j)) {
                    maxCore++;
                    continue;
                }

                if (map[i][j] == 1 && !isConneted(i, j)) {
                    cores.add(new int[]{i, j});
                }
            }
        }
    }

    private static void findAnswer(int idx, int core, int wire) {
        if(idx == cores.size()) {
            if(core > maxCore) {
                maxCore = core;
                minWire = wire;
            } else if (maxCore == core) {
                minWire = Math.min(minWire,wire);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(canConnect(cores.get(idx), i)) {
                fill(cores.get(idx), i, WIRE);
                findAnswer(idx + 1, core + 1, wire + wireCnt);
                fill(cores.get(idx), i, 0);
            }
        }
        findAnswer(idx + 1, core, wire);
    }

    private static void fill(int[] index, int dir, int value) {
        wireCnt = 0;

        int x = index[0] + dr[dir];
        int y = index[1] + dc[dir];
        while (x >= 0 && y >= 0 && x < N && y < N) {
            map[x][y] = value;
            wireCnt++;
            x = x + dr[dir];
            y = y + dc[dir];
        }
    }


    private static boolean isConneted(int row, int col) {
        return row == 0 || col == 0 || row == N - 1 || col == N - 1;
    }

    private static boolean canConnect(int[] index, int dir) {
        int x = index[0] + dr[dir];
        int y = index[1] + dc[dir];

        while (x >= 0 && y >= 0 && x < N && y < N) {
            if (map[x][y] != 0) return false;
            x = x + dr[dir];
            y = y + dc[dir];
        }
        return true;
    }

}
