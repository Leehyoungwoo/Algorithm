package codetree.intermediateMid.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class findMaxNum {

    private static int n;
    private static int m;
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            priorityQueue.add(-Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int n = -priorityQueue.poll();
            priorityQueue.add(-(n - 1));
        }

        System.out.println(-priorityQueue.peek());
    }
}
