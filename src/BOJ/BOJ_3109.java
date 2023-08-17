package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
    private static int r;
    private static int c;
    private static char[][] map;
    private static int pipeCnt = 0;
    private static int[] dy = {-1, 0, 1};
    private static boolean arrive;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < map.length; i++) {
            findPipeWay(i, 0);
            arrive = false;
        }
        System.out.println(pipeCnt);
    }

    private static void findPipeWay(int row, int col) {
        if(col == c - 1) {
            pipeCnt++;
            arrive = true;
            return;
        }
        if(map[row][col] == 'x') {
            arrive = false;
            return;
        }

        map[row][col] = 'x';

        for (int i = 0; i < dy.length; i++) {
            int nextR = row + dy[i];
            int nextC = col + 1;

            if(isInRange(nextR, nextC)) {
                findPipeWay(nextR, nextC);
                if(arrive) {
                    return;
                }
            }
        }
    }

    private static boolean isInRange(int nextRow, int nextCol) {
        return (0 <= nextRow && nextRow < r) && (0 <= nextCol && nextCol < c);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        map = new char[r][c];

        for (int i = 0; i < map.length; i++) {
            String str = input.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }
}