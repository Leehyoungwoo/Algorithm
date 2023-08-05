package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {

    private static int min = Integer.MAX_VALUE;
    private static int N;
    private static int[][] taste;

    public static void main(String[] args) throws IOException {
        init();
        findMinDiff(0, 0, 1, 0);
        System.out.println(min);
    }

    private static void findMinDiff(int cnt, int input, int mul, int sum) {
        if (cnt == N) {
            if (input != 0) {
                min = Math.min(min, Math.abs(sum - mul));
            }
            return;
        }
        findMinDiff(cnt + 1, input, mul, sum);
        findMinDiff(cnt + 1, input + 1, mul * taste[0][cnt], sum + taste[1][cnt]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        taste = new int[2][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            taste[0][i] = Integer.parseInt(st1.nextToken());
            taste[1][i] = Integer.parseInt(st1.nextToken());
        }
    }
}
