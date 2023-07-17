package codetree.completeSearch2;

import java.util.*;

public class FindTheNumberOfPalindromes {

    private static final int RANGE = Integer.toString(1_000_000).length();
    private static int x;
    private static int y;

    public static void main(String[] args) {
        init();
        System.out.println(answer());
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        y = input.nextInt();
    }

    private static int answer() {
        char[] num = new char[RANGE];
        char[] reverseNum = new char[RANGE];
        int falindrom = 0;

        for (int i = x; i <= y; i++) {
            String str = Integer.toString(i);
            int reverseIdx = str.length() - 1;
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                num[j] = str.charAt(j);
                reverseNum[j] = str.charAt(reverseIdx--);
            }

            for (int j = 0; j < str.length(); j++) {
                if(num[j] == reverseNum[j]) {
                    cnt++;
                }
            }
            if(cnt == str.length()) {
                falindrom++;
            }
        }
        return falindrom;
    }
}