package codetree.intermediateMid.treemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LocationFirstAppearance {

    private static int n;
    private static TreeMap<Integer, Integer> map = new TreeMap<>();
    private static String[] s;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        s = input.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            int n = Integer.parseInt(s[i]);
            if (map.get(n) != null) {
                continue;
            }
            map.put(n, i + 1);
        }
    }

    private static void findAnswer() {
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
