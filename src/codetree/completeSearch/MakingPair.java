package codetree.completeSearch;

import java.util.*;

public class MakingPair {

    private static char[] ch;
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) {
        init();
        System.out.print(findPair());
    }

    private static int findPair() {
        int cnt = 0;

        for (int i = 0; i < ch.length-1; i++) {
            for (int j = i + 1; j < ch.length-1; j++) {
                if(ch[i] == '(' && ch[i+1] == '('
                && ch[j] == ')' && ch[j+1] == ')') {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
    }
}