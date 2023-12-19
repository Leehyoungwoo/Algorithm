package codetree.intermediateMid.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BasicHashset {

    private static int n;
    private static String[] order;
    private static HashSet<Integer> set = new HashSet<>();

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
                set.add(Integer.parseInt(s[1]));
                continue;
            }

            if (s[0].equals("remove")) {
                set.remove(Integer.parseInt(s[1]));
                continue;
            }

            if (s[0].equals("find")) {
                if(set.contains(Integer.parseInt(s[1]))) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }

}
