package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visted;


    public static void main(String[] args) throws IOException {
        init();
        int answer = findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        visted = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static int findAnswer() {
        int min = Integer.MAX_VALUE;

        return min;
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
