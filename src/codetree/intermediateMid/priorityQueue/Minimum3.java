package codetree.intermediateMid.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Minimum3 {

    private static int n;
    private static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    private static List<Long> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(tokenizer.nextToken());
            priorityQueue.add(a);
            if (priorityQueue.size() < 3) {
                System.out.println(-1);
            } else {
                long mul = 1;
                for (int j = 0; j < 3; j++) {
                    long b = priorityQueue.poll();
                    mul *= b;
                    list.add(b);
                }
                System.out.println(mul);
                priorityQueue.addAll(list);
                list.clear();
            }
        }
    }
}
