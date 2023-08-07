package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218 {

    private static int TEST_CASE = 10;
    private static int range;
    private static String str;
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TEST_CASE; tc++) {
            init(br);
            sb.append("#").append(tc).append(" ").append(findAnswer()).append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }


    private static int findAnswer() {
        if (isValidStr()) {
            return 1;
        }
        return 0;
    }

    private static boolean isValidStr() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.size() != 0 && isMatched(c)) {
                    stack.pop();
                    continue;
            }
            stack.push(c);
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

    private static boolean isMatched(char c) {
        if (c == ')' && stack.peek() == '(') {
            return true;
        }

        if (c == ']' && stack.peek() == '[') {
            return true;
        }

        if (c == '}' && stack.peek() == '{') {
            return true;
        }

        if (c == '>' && stack.peek() == '<') {
            return true;
        }

        return false;
    }

    private static void init(BufferedReader br) throws IOException {
        range = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
}
