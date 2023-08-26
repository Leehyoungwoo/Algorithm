package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {

    private static int n;
    private static int m;
    private static final int ABCDE_Is_FRIEND = 5;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        init();
        findIsExistFriendOrNot();
    }

    private static void findIsExistFriendOrNot() {
        for (int i = 0; i < n; i++) {
            int depth = dfs(i, new boolean[n]);
            if (depth >= ABCDE_Is_FRIEND) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static int dfs(int start, boolean[] visited) {
        visited[start] = true;
        int max = 1;

        for (int neighbor : adjList[start]) {
            if (!visited[neighbor]) {
                max = Math.max(max, dfs(neighbor, visited) + 1);
                if(max == 5) {
                    return max;
                }
            }
        }
        visited[start] = false;
        return max;
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer2 = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokenizer2.nextToken());
            int b = Integer.parseInt(tokenizer2.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }
}