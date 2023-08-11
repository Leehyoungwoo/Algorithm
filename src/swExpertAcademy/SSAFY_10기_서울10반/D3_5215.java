package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Food {

    int score;
    int cal;

    public Food(int score, int cal) {
        this.score = score;
        this.cal = cal;
    }
}

public class D3_5215 {

    private static int testCase;
    private static int N;
    private static int L;
    private static Food[] hambug;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            init(br);
            sb.append("#").append(tc).append(" ").append(answer(0, new boolean[N], 0)).append("\n");
        }

        System.out.println(sb);
    }

    private static int answer(int cnt, boolean[] visited, int calSum) {
        if (cnt == N) {
            return 0;
        }

        int score = hambug[cnt].score;
        int cal = hambug[cnt].cal;

        int scorePick = 0;
        visited[cnt] = true;
        if (calSum + cal <= L) {
            scorePick = score + answer(cnt + 1, visited, calSum + cal);
        }

        visited[cnt] = false;
        int scoreOut = answer(cnt + 1, visited, calSum);

        return Math.max(scorePick, scoreOut);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        hambug = new Food[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st1.nextToken());
            int cal = Integer.parseInt(st1.nextToken());
            hambug[i] = new Food(score, cal);
        }
    }
}