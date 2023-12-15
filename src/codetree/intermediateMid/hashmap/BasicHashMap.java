package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BasicHashMap {

    private static int n;
    private static String[] order;
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        followOrder();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        order = new String[n];

        for (int i = 0; i < n; i++) {
            order[i] = input.readLine();
        }
    }


    private static void followOrder() {
        for (int i = 0; i < n; i++) {
            String[] s = order[i].split(" ");
            int v1 = Integer.parseInt(s[1]);
            if(s.length == 3) {
                int v2 = Integer.parseInt(s[2]);
                if (s[0].equals("add")) {
                    map.put(v1, v2);
                    continue;
                }
                continue;
            }

            if (s[0].equals("find")) {
                if (!map.containsKey(v1)) {
                    System.out.println("None");
                    continue;
                }
                System.out.println(map.get(v1));

            }

            if (s[0].equals("remove")) {
                map.remove(v1);
            }
        }
    }
}
