package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LowPoints {

    private static int n;
    private static Map<Long, Long> map = new HashMap<>();
    private static String[] xy;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        xy = new String[n];
        for (int i = 0; i < n; i++) {
            xy[i] = input.readLine();
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < xy.length; i++) {
            String[] s = xy[i].split(" ");
            long x = Long.parseLong(s[0]);
            long y = Long.parseLong(s[1]);
            if (map.get(x) == null) {
                map.put(x, y);
                continue;
            }
            map.put(x, Math.min(y, map.get(x)));
        }
    }

    private static void printAnswer() {
        AtomicLong sum = new AtomicLong(0);
        map.forEach((key, value) -> sum.addAndGet(value));
        System.out.println(sum.get());
    }
}
