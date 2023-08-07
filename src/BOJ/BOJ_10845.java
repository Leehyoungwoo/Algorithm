package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10845 {

    private static int N;
    private static String[] orders;
    private static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();
        findAnswer(sb);
        System.out.println(sb);
    }

    private static void findAnswer(StringBuilder sb) {
        for (int i = 0; i < orders.length; i++) {
            followOrder(orders[i], sb);
        }
    }

    private static void followOrder(String order, StringBuilder sb) {
        if (order.contains("push")) {
            String[] s = order.split(" ");
            queue.addLast(Integer.parseInt(s[1]));
        }

        if(order.equals("pop")) {
            if(queue.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(queue.poll()).append("\n");
            return;
        }

        if (order.equals("size")) {
            sb.append(queue.size()).append("\n");
            return;
        }

        if (order.equals("front")) {
            if(queue.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(queue.peekFirst()).append("\n");
            return;
        }

        if (order.equals("back")) {
            if (queue.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(queue.peekLast()).append("\n");
            return;
        }

        if (order.equals("empty")) {
            if (queue.isEmpty()) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
            return;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        orders = new String[N];

        for (int i = 0; i < N; i++) {
            orders[i] = br.readLine();
        }
    }
}
