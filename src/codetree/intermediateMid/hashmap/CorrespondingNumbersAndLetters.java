package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CorrespondingNumbersAndLetters {

    private static int n;
    private static int m;
    private static Map<String, Integer> map = new HashMap<>();
    private static Map<Integer, String> reverseMap = new HashMap<>();
    private static String[] order;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        order = new String[m];

        for (int i = 1; i <= n; i++) {
            String s = input.readLine();
            map.put(s, i);
            reverseMap.put(i, s);
        }

        for (int i = 0; i < m; i++) {
            order[i] = input.readLine();
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < m; i++) {
            if (isNumberic(order[i])) {
                System.out.println(reverseMap.get(Integer.parseInt(order[i])));
            } else {
                System.out.println(map.get(order[i]));
            }
        }
    }

    private static boolean isNumberic(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
