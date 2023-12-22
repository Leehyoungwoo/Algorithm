package codetree.intermediateMid.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class findMinNum {

    private static int n;
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(input.readLine());
            if (x != 0) {
                priorityQueue.add(x);
                continue;
            }
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(priorityQueue.poll());
            }
        }
    }
}
