package codetree.intermediateMid.treemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BasicTreeMap {

    private static int n;
    private static String[] order;
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());

        order = new String[n];
        for (int i = 0; i < n; i++) {
            order[i] = input.readLine();
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < n; i++) {
            String[] s = order[i].split(" ");
            if (s[0].equals("add")) {
                int k = Integer.parseInt(s[1]);
                int v = Integer.parseInt(s[2]);
                map.put(k, v);
                continue;
            }

            if (s[0].equals("find")) {
                if (map.get(Integer.parseInt(s[1])) == null) {
                    System.out.println("None");
                    continue;
                }
                System.out.println(map.get(Integer.parseInt(s[1])));
                continue;
            }
            if (s[0].equals("remove")) {
                map.remove(Integer.parseInt(s[1]));
                continue;
            }

            if (s[0].equals("print_list")) {
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

                if (!it.hasNext()) {
                    System.out.println("None");
                    continue;
                }

                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    System.out.print(entry.getValue() + " ");
                }
                System.out.println();
            }
        }
    }
}
