package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupWords {

    private static int n;
    private static Map<String, Integer> map = new HashMap<>();
    private static String[] words;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = input.readLine();
        }

    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            char[] word = words[i].toCharArray();
            Arrays.sort(word);
            String sortWord = new String(word);
            map.put(sortWord, map.getOrDefault(sortWord, 0) + 1);
        }
    }

    private static void printAnswer() {
        AtomicInteger max = new AtomicInteger(0);
        map.forEach((key, value) -> max.set(Math.max(max.get(), value)));
        System.out.println(max.get());
    }
}
