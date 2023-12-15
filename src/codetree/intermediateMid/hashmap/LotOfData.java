package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LotOfData {

    static int n;
    static String[] str;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = input.readLine();
            if (map.get(str[i]) == null) {
                map.put(str[i], 1);
                continue;
            }
            map.put(str[i], map.get(str[i]) + 1);
        }
    }

    private static void findAnswer() {
        AtomicInteger max = new AtomicInteger(0);
        map.forEach((key, value) -> max.set(Math.max(max.get(), value)));
        System.out.println(max);
    }
}
