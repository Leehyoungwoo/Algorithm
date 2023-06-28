package codetree.notation;

import java.util.*;

public class BlockingCommand2 {

    private static int N;
    private static int K;
    private static int[] map;

    private static List<int[]> command = new ArrayList<>();

    public static void main(String[] args) {
        init();
        blocking();
        Arrays.sort(map);
        printMaxBlock();
    }

    private static void printMaxBlock() {
        System.out.println(map[N]);
    }

    private static void blocking() {
        for (int i = 0; i < K; i++) {
            int start = command.get(i)[0];
            int end = command.get(i)[1];
            blockingInMap(start, end);
        }
    }

    private static void blockingInMap(int start, int end) {
        for (int i = start; i < end + 1; i++) {
            map[i]++;
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        map = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int[] nums = {input.nextInt(), input.nextInt()};
            command.add(nums);
        }

        for (int i = 0; i < map.length; i++) {
            map[i] = 0;
        }
    }
}
