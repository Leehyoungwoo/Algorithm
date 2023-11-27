import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RecMinOfMax {

    private static final int[][] direction = { { 0, 1 }, { 1, 0 } };
    private static int n;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        dp[0][0] = map[0][0];
        dfs(0, 0);
        System.out.println(dp[n - 1][n - 1]);
    }

    private static void dfs(int row, int col) {
        for (int[] dir : direction) {
            int nextR = row + dir[0];
            int nextC = col + dir[1];
            if (isInRange(nextR, nextC)) {
                int curMax = Math.max(map[nextR][nextC], dp[row][col]);
                if (dp[nextR][nextC] == 0 || dp[nextR][nextC] > curMax) {
                    dp[nextR][nextC] = curMax;
                    dfs(nextR, nextC);
                }
            }
        }
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());

        dp = new int[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}
