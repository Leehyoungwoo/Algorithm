package codetree.intermediateMid.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FindInteger {

    private static int n;
    private static HashSet<Integer> set1 = new HashSet<>();
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            set1.add(Integer.parseInt(tokenizer.nextToken()));
        }
        m = Integer.parseInt(input.readLine());
        arr = new int[m];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < m; i++) {
            if(set1.contains(arr[i])){
                System.out.println(1 + " ");
                continue;
            }
            System.out.println(0 + " ");
        }
    }

}
