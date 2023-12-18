package codetree.intermediateMid.treemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FindRatio {

    private static int n;
    private static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String color = input.readLine();
            map.put(color, map.getOrDefault(color, 0) + 1);
        }
    }


    private static void findAnswer() {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            double ratio = entry.getValue() / (double) n;
            System.out.println(entry.getKey() + " "+ String.format("%.4f", ratio * 100));
        }
    }

}
