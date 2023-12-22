package codetree.intermediateMid.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BasicPriorityQueue {

    private static int n;
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = input.readLine().split(" ");
            if (s[0].equals("push")) {
                priorityQueue.add(-Integer.parseInt(s[1]));
                continue;
            }

            if (s[0].equals("size")) {
                System.out.println(priorityQueue.size());
                continue;
            }

            if (s[0].equals("empty")) {
                if(priorityQueue.isEmpty()) {
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
                continue;
            }

            if (s[0].equals("pop")) {
                System.out.println(-priorityQueue.poll());
                continue;
            }

            if (s[0].equals("top")) {
                System.out.println(-priorityQueue.peek());
            }
        }
    }
}
