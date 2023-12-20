package codetree.intermediateMid.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class findMaxNum {

    private static int n;
    private static int m;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= m; i++) {
            set.add(i);
        }

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            set.remove(num);
            System.out.println(set.last());
        }
    }
}
