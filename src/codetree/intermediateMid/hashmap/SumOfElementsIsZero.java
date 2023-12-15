package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumOfElementsIsZero {

    private static int[][] nums;
    private static int n;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        nums = new int[4][n];
        for (int i = 0; i < 4; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums[0][i] + nums[1][j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }

    private static void printAnswer() {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -1 * (nums[2][i] + nums[3][j]);
                count += map.getOrDefault(sum, 0);
            }
        }
        System.out.println(count);
    }
}
