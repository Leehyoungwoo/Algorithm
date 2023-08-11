package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class X implements Comparable<X>{
    int value;
    int absoluteValue;

    public X(int value) {
        this.value = value;
        this.absoluteValue =  Math.abs(value);
    }

    @Override
    public int compareTo(X target) {
        if (this.absoluteValue < target.absoluteValue) {
            return -1;
        } else if (this.absoluteValue > target.absoluteValue) {
            return 1;
        } else {
            if (this.value < target.value) {
                return -1;
            } else if (this.value > target.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

public class BOJ_11286 {

    private static int N;
    private static PriorityQueue<X> que = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if(que.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(que.poll()).append("\n");
                continue;
            }
            que.add(new X(num));
        }

        System.out.println(sb);
    }
}