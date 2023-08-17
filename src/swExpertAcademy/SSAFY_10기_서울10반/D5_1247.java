package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247 {

    private static int testCase;
    private static int n;
    private static int[][] customer;
    private static final int COMPANY = 0;
    private static final int HOME = 1;
    private static int minDidtance = Integer.MAX_VALUE;
    private static int[] per;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            init(input);
            findMinDistance(1, new boolean[n+2]);
            sb.append("#").append(tc).append(" ").append(minDidtance).append("\n");
            minDidtance = Integer.MAX_VALUE;
        }

        System.out.println(sb);
    }

    private static void findMinDistance(int idx, boolean[] visited) {
        if(idx == n + 1) {
            per[0] = COMPANY;
            per[per.length-1] = HOME;
            int dis = calculateDis();
            minDidtance = Math.min(minDidtance, dis);
            return;
        }

        for(int i = 2; i < n + 2; i++) {
            if(!visited[i]) {
                visited[i] = true;
                per[idx] = i;
                findMinDistance(idx + 1, visited);
                visited[i] = false;
            }
        }
    }

    private static int calculateDis() {
        int sum = 0;

        for (int i = 0; i < per.length - 1; i++) {
            sum+=abs(customer[per[i]][0] - customer[per[i+1]][0]) + abs(customer[per[i]][1] - customer[per[i+1]][1]);
        }

        return sum;
    }

    private static int abs(int n) {
        return Math.abs(n);
    }

    private static void init(BufferedReader input) throws IOException {
        n = Integer.parseInt(input.readLine());
        customer = new int[n + 2][2];
        per = new int[n + 2];
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        for (int i = 0; i < customer.length; i++) {
            for (int j = 0; j < customer[i].length; j++) {
                customer[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}