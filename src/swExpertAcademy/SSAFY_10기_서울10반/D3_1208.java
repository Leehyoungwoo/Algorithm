package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.Scanner;

public class D3_1208 {

    private static final int TEST_CASE = 10;
    private static final int RANGE = 100;
    private static int[] map;
    private static int dumpCnt;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < TEST_CASE; i++) {
            init(input);
            dump();
            System.out.println("#" + (i+1) + " "+MaxMinDiff());
        }
    }

    private static int MaxMinDiff() {
        return findMax() - findMin();
    }

    private static void dump() {
        int maxIdx = findMaxIdx();
        int minIdx = findMinIdx();
        for (int i = 0; i < dumpCnt; i++) {
            if (maxIdx == minIdx) {
                return;
            }
            map[maxIdx]--;
            map[minIdx]++;
            maxIdx = findMaxIdx();
            minIdx = findMinIdx();
        }

    }


    private static int findMinIdx() {
        int minIdx = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[i] < map[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int findMaxIdx() {
        int maxIdx = 0;

        for (int i = 0; i < map.length; i++) {
            if(map[maxIdx] < map[i]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    private static int findMax() {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            if(map[i] == 0) {
                continue;
            }
            max = Math.max(max, map[i]);
        }
        return max;
    }

    private static int findMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if(map[i] == 0) {
                continue;
            }
            min = Math.min(min, map[i]);
        }
        return min;
    }

    private static void init(Scanner input) {
        dumpCnt = input.nextInt();
        map = new int[RANGE];

        for (int i = 0; i < map.length; i++) {
            map[i] = input.nextInt();
        }
    }
}