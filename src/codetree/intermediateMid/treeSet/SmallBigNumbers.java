package codetree.intermediateMid.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SmallBigNumbers {

    private static int n;
    private static int m;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(tokenizer.nextToken());
            set.add(x);
        }

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < m; i++) {
            int y = Integer.parseInt(tokenizer.nextToken());
            if (set.contains(y)) {
                System.out.println(y);
                set.remove(y);
                continue;
            }

            if (set.lower(y) != null) {
                System.out.println(set.lower(y));
                set.remove(set.lower(y));
                continue;
            }

            System.out.println(-1);
        }
    }
}
