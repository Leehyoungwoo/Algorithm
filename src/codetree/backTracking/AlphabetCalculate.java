package codetree.backTracking;

import java.util.*;
import java.io.*;

public class AlphabetCalculate {

    private static String str;
    private static List<Integer> number;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine();
        number = new ArrayList<>();

    }

    private static void dfs(int idx) {
        if (idx == 6) {
            int num = findCalculateSik();
            answer = Math.max(answer, num);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            number.add(i);
            dfs(idx + 1);
            number.remove(number.size() - 1);
        }
    }

    private static int findCalculateSik() {
        int num = decideNum(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(sachick(ch)) {
                num = calcuate(num, ch ,decideNum(str.charAt(i + 1)));
            }
        }

        return num;
    }

    private static boolean sachick(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int calcuate(int num, char c, int m) {
        if (c == '+') {
            return num + m;
        }

        if (c == '-') {
            return num - m;
        }

        if (c == '*') {
            return num * m;
        }

        return num / m;
    }

    public static int decideNum(char c) {
        return number.get(c - 'a');
    }
}
