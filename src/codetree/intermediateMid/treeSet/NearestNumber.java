package codetree.intermediateMid.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NearestNumber {

    private static int n;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        set.add(0);
        int minDistance = Integer.MAX_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(tokenizer.nextToken());
            set.add(x);

            Integer higher = set.higher(x);
            Integer lower = set.lower(x);


            if (lower != null) {
                minDistance = Math.min(minDistance, x - lower);
            }

            if (higher != null) {
                minDistance = Math.min(minDistance, higher - x);
            }

            System.out.println(minDistance);
        }
    }
}
