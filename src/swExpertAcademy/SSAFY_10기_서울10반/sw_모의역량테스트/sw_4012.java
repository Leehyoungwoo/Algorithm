package swExpertAcademy.SSAFY_10기_서울10반.sw_모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_4012 {

    private static int testCase;
    private static int n;
    private static int[][] map;
    private static int minDiffTaste = Integer.MAX_VALUE;
    private static List<Integer> firstDish = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            init(input);
            dfs(0, 0);
            sb.append('#').append(tc).append(' ').append(minDiffTaste).append('\n');
            minDiffTaste = Integer.MAX_VALUE;
        }
        System.out.print(sb);
    }

    private static void dfs(int idx, int start) {
        if (idx == n / 2) {
            int diff = calculateMinTaste();
            minDiffTaste = Math.min(minDiffTaste, diff);
            return;
        }
        if (start == n) {
            return;
        }
        firstDish.add(start);
        dfs(idx + 1, start + 1);
        firstDish.remove(idx);
        dfs(idx, start + 1);
    }

    private static int calculateMinTaste() {
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < firstDish.size(); i++) {
            for (int j = i + 1; j < firstDish.size(); j++) {
                firstSum += map[firstDish.get(i)][firstDish.get(j)] + map[firstDish.get(j)][firstDish.get(i)];
            }
        }
        for (int i = 0; i < n; i++) {
            if (firstDish.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (firstDish.contains(j)) {
                    continue;
                }
                secondSum += map[i][j] + map[j][i];
            }
        }

        return Math.abs(firstSum - secondSum);
    }

    private static void init(BufferedReader input) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}
