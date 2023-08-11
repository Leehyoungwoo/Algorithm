package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

    private static int N;
    private static int M;
    private static int R;
    private static int[][] map;
    private static int[][] rotatedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        String[] orders = br.readLine().split(" ");

        for (int i = 0; i < R; i++) {
            rotate(Integer.parseInt(orders[i]));
        }
        printMap();
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotate(int orders) {
        if (orders == 1) {
            rotatedMap = new int[N][M];
            int yidx = 0;

            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < map[i].length; j++) {
                    rotatedMap[yidx][j] = map[i][j];
                }
                yidx++;
            }
            map = rotatedMap;

        }

        if (orders == 2) {
            rotatedMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                int xidx = 0;
                for (int j = M - 1; j >= 0; j--) {
                    rotatedMap[i][xidx] = map[i][j];
                    xidx++;
                }
            }
            map = rotatedMap;

        }

        if (orders == 3) {
            rotatedMap = new int[M][N];
            int idx = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    rotatedMap[i][j] = map[N - 1 - j][i];
                }
                idx++;
            }
            int temp = N;
            N = M;
            M = temp;
            map = rotatedMap;
        }

        if (orders == 4) {
            rotatedMap = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    rotatedMap[i][j] = map[j][M - 1 - i];
                }
            }
            int temp = N;
            N = M;
            M = temp;
            map = rotatedMap;
        }

        if (orders == 5) {
            int curx = 0;
            int cury = 0;
            rotatedMap = new int[N][M];

            for (int i = N / 2; i <= N - 1; i++) {
                for (int j = 0; j <= M / 2 - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = 0;
                cury++;
            }

            curx = M / 2;
            cury = 0;
            for (int i = 0; i <= N / 2 - 1; i++) {
                for (int j = 0; j <= M / 2 - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = M / 2;
                cury++;
            }

            curx = 0;
            cury = N / 2;
            for (int i = N / 2; i <= N - 1; i++) {
                for (int j = M / 2; j <= M - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = 0;
                cury++;
            }
            cury = N / 2;
            curx = M / 2;
            for (int i = 0; i <= N / 2 - 1; i++) {
                for (int j = M / 2; j <= M - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = M / 2;
                cury++;
            }
            map = rotatedMap;

        }

        if (orders == 6) {
            int curx = 0;
            int cury = 0;
            rotatedMap = new int[N][M];

            for (int i = 0; i <= N/2 - 1; i++) {
                for (int j = M / 2; j <= M - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = 0;
                cury++;
            }

            curx = M / 2;
            cury = 0;
            for (int i = N / 2; i <= N - 1; i++) {
                for (int j = M / 2; j <= M - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = M / 2;
                cury++;
            }

            curx = 0;
            cury = N/2;
            for (int i = 0; i <= N/2 - 1; i++) {
                for (int j = 0; j <= M/2 - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = 0;
                cury++;
            }
            curx = M / 2;
            cury = N / 2;
            for (int i = N/2; i <= N - 1; i++) {
                for (int j = 0; j <= M/2 - 1; j++) {
                    rotatedMap[cury][curx] = map[i][j];
                    curx++;
                }
                curx = M / 2;
                cury++;
            }
            map = rotatedMap;

        }
    }


    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
    }
}