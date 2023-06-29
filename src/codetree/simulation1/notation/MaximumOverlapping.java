package codetree.simulation1.notation;

import java.util.*;

public class MaximumOverlapping {

    private static int n;
    private static List<int[]> line = new ArrayList<>();

    private static int[] map = new int[201];
    private static int OFFSET = 100;

    public static void main(String[] args) {
        init();
        makeLineInMap();
        int answer = findOverlapLine();
        System.out.print(answer);
    }

    private static int findOverlapLine() {
        int max = map[0];
        for (int i = 1; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
            }
        }
        return max;
    }

    private static void makeLineInMap() {
        for (int i = 0; i < line.size(); i++) {
            int start = line.get(i)[0];
            int end = line.get(i)[1];
            lineMarking(start, end);
        }
    }

    private static void lineMarking(int start, int end) {
        for (int i = start; i < end; i++) {
            map[i]++;
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

                int[] nums = {a+OFFSET, b+OFFSET};
            line.add(nums);
        }
    }
}
