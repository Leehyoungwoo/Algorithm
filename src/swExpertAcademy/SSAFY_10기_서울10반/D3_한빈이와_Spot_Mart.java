package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_한빈이와_Spot_Mart {

    private static int TC;
    private static int N;
    private static int M;
    private static int[] cookies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            init(br);
            sb.append("#").append(tc).append(" ").append(findMaxWeight()).append("\n");
        }

        System.out.println(sb);
    }

    private static int findMaxWeight() {
        int max = -1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = cookies[i] + cookies[j];
                if (sum > M) {
                    continue;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static void init(BufferedReader br) throws IOException {
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        cookies = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }
    }
}