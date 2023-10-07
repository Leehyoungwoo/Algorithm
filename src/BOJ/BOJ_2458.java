import java.util.*;
import java.io.*;

public class BOJ_2458 {

    private static int N;
    private static int M;
    private static List<List<Integer>> in;
    private static List<List<Integer>> out;

    public static void main(String[] args) throws IOException {
        init();
        int ans = findAnswer();
        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        in = new ArrayList<>();
        out = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            in.add(new ArrayList<>());
            out.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            in.get(a).add(b);
            out.get(b).add(a);
        }
    }

    private static int findAnswer() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isDefinated(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean isDefinated(int start) {
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer in : in.get(cur)) {
                if (!visited[in]) {
                    cnt++;
                    visited[in] = true;
                    queue.add(in);
                }
            }
        }

        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer out : out.get(cur)) {
                if (!visited[out]) {
                    cnt++;
                    visited[out] = true;
                    queue.add(out);
                }
            }
        }

        if (cnt == N - 1) {
            return true;
        }

        return false;
    }
}