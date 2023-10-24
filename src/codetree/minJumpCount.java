package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minJumpCount {

    private static int n;
    private static int[] num;
    private static int minJump = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        if(minJump == Integer.MAX_VALUE) minJump = -1;
        System.out.println(minJump);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        num = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void dfs(int idx, int jump) {
        if (idx == n - 1) {
            minJump = Math.min(minJump, jump);
            return;
        }

        if (num[idx] == 0) {
            return;
        }

        for (int i = 1; i <= num[idx]; i++) {
            if (idx + i > n - 1) {
                return;
            }
            dfs(idx + i, jump + 1);
        }
    }
}
