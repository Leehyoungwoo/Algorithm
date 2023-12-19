package codetree.intermediateMid.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DifferentNumbers {

    private static int n;
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(set.size());
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(tokenizer.nextToken()));
        }
    }
}
