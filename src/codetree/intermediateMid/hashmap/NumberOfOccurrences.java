package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberOfOccurrences {

    private static int n;
    private static int m;
    private static Map<Integer, Integer> map = new HashMap<>();

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
            int n = Integer.parseInt(tokenizer.nextToken());
            if (map.get(n) == null) {
                map.put(n, 1);
                continue;
            }
            map.put(n, map.get(n) + 1);
        }

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(tokenizer.nextToken());
            if(map.get(a) == null) {
                System.out.print(0 + " ");
                continue;
            }

            System.out.print(map.get(a) +  " ");
        }
    }
}
