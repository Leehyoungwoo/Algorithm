package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Subin {
    int position;
    int level;

    public Subin(int position, int level) {
        this.position = position;
        this.level = level;
    }
}

public class BOJ_1697 {

    private static int n;
    private static int k;
    private static final int RANGE = 100_000;
    private static Queue<Subin> que = new LinkedList<>();
    private static int findTime = 0;
    private static boolean[] visited = new boolean[RANGE + 1];

    public static void main(String[] args) throws IOException {
        init();
        findDongSang();
        System.out.println(findTime);
    }

    private static void push(int p, int level) {
        visited[p] = true;
        que.add(new Subin(p , level));
    }

    private static void findDongSang() {
        push(n , 0);
        while(!que.isEmpty()) {
            Subin cur = que.poll();
            int curPosition = cur.position;
            int curLevel = cur.level;
            int[] moving = {curPosition, -1, 1};

            if (curPosition == k) {
                findTime = curLevel;
                return;
            }

            for (int i = 0; i < moving.length; i++) {
                int nextCur = curPosition + moving[i];

                if(isInRange(nextCur) && !visited[nextCur]) {
                    push(nextCur , curLevel + 1);
                }
            }
        }
    }

    private static boolean isInRange(int nextCur) {
        return 0 <= nextCur && nextCur < RANGE + 1;
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] s = input.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
    }
}