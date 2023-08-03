package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.*;

public class D2_2001 {

    private static int T;
    private static int N;
    private static int M;
    private static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            sb.append("#").append(tc).append(" ").append(findMaxFlyKill()).append("\n");
        }

        System.out.println(sb);
    }

    private static int findMaxFlyKill() {
        int max = 0;
        for (int i = 1; i < prefixSum.length -(M - 1); i++) {
            for (int j = 1; j < prefixSum[i].length - (M - 1); j++) {
                int kill = findDyingFlys(i, j, i + M -1, j + M - 1);
                max = Math.max(max, kill);
            }
        }
        return max;
    }

    private static int findDyingFlys(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x2][y1 -1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1];
    }

    private static void init(Scanner input)  {
        N = input.nextInt();
        M = input.nextInt();
        prefixSum = new int[N+1][N+1];

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i - 1][j - 1] + input.nextInt();
            }
        }
    }
}