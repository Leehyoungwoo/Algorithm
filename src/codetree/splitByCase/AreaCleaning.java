package codetree.splitByCase;

import java.util.*;

public class AreaCleaning {

    private static int a, b, c, d;
    private static int[] map = new int[101];

    public static void main(String[] args) {
        init();
        System.out.print(answer());
    }

    private static int answer() {
        int answer = 0;
        for (int i = a; i < b; i++) {
            map[i] = 1;
        }
        for (int i = c; i < d; i++) {
            map[i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if(map[i] != 0) {
                answer++;
            }
        }
        return answer;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        d = input.nextInt();

    }
}