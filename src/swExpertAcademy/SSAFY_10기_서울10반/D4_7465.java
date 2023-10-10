package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_7465 {

    private static int T;
    private static int N;
    private static int M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            int ans = findAnswer();
            answer.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(answer);
    }

    private static void init(BufferedReader input) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private static int findAnswer() {
        int groupNum = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            makingGroup(i);
            groupNum++;
        }

        return groupNum;
    }

    private static void makingGroup(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Integer next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }

}