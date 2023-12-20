package codetree.intermediateMid.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BasicTreeSet {

    private static int n;
    private static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] order = input.readLine().split(" ");
            if (order[0].equals("add")) {
                set.add(Integer.parseInt(order[1]));
            }

            if (order[0].equals("remove")) {
                if (set.contains(Integer.parseInt(order[1]))) {
                    set.remove(Integer.parseInt(order[1]));
                    continue;
                }
                System.out.println("false");
            }

            if (order[0].equals("find")) {
                if (set.contains(Integer.parseInt(order[1]))) {
                    System.out.println("true");
                    continue;
                }
                System.out.println("false");
            }

            if (order[0].equals("lower_bound")) {
                if (set.ceiling(Integer.parseInt(order[1])) != null) {
                    System.out.println(set.ceiling(Integer.parseInt(order[1])));
                    continue;
                }
                System.out.println("None");
            }

            if (order[0].equals("upper_bound")) {
                if (set.higher(Integer.parseInt(order[1])) != null) {
                    System.out.println(set.higher(Integer.parseInt(order[1])));
                    continue;
                }
                System.out.println("None");
            }

            if (order[0].equals("largest")) {
                if (!set.isEmpty()) {
                    System.out.println(set.last());
                    continue;
                }
                System.out.println("None");
            }

            if (order[0].equals("smallest")) {
                if (!set.isEmpty()) {
                    System.out.println(set.first());
                    continue;
                }
                System.out.println("None");
            }
        }
    }
}
