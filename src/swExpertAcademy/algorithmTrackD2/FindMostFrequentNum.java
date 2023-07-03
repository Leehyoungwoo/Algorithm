package swExpertAcademy.algorithmTrackD2;

import java.util.*;

public class FindMostFrequentNum {

    private static int T;
    private static int caseNum;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        for (int t = 0; t < T; t++) {
            caseNum = input.nextInt();
            for (int i = 0; i < 1_000; i++) {
                int n = input.nextInt();
                if (!map.containsKey(n)) {
                    map.put(n, 1);
                } else {
                    map.put(n, map.get(n) + 1);
                }
            }
            int maxF = findNumber();
            System.out.println("#" + caseNum + " " + maxF);
            map.clear();
        }

    }

    private static int findNumber() {
        int max = 0;
        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            if (map.get(i) == null) {
                continue;
            }

            if (map.get(i) > max) {
                max = map.get(i);
                answer = i;
            }else if (map.get(i) == max) {
                if (i > answer) {
                    answer = i;
                }
            }
        }
        return answer;
    }
}
