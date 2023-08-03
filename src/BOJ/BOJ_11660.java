package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11660 {

    private static int[][] prefixSum;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(bf, st);

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());
            int x2 = Integer.parseInt(st1.nextToken());
            int y2 = Integer.parseInt(st1.nextToken());

            bw.write(Integer.toString(findAnswer(x1, y1, x2, y2)) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int findAnswer(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1];
    }

    private static void init(BufferedReader bf, StringTokenizer st) throws IOException {
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N + 1][N + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            for (int j = 1; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + Integer.parseInt(st1.nextToken());
            }
        }
    }
}