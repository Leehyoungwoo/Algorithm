package codetree.intermediateMid.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DeleteFromTheFront {
    public static int n;
    public static int[] arr;
    public static int sum;
    public static double maxAvg;
    public static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
    }

    private static void findAnswer() {
        for (int i = n - 2; i >= 1; i--) {
            priorityQueue.add(arr[i]);
            sum += arr[i];
            double avg = (double) (sum - priorityQueue.peek()) / (n - i - 1);
            maxAvg = Math.max(avg, maxAvg);
        }

        System.out.printf("%.2f", maxAvg);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        priorityQueue.add(arr[n - 1]);
        sum += arr[n - 1];
    }
}