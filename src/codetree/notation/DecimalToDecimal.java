package codetree.notation;

import java.util.*;

public class DecimalToDecimal {

    private static int a, b;
    private static String n;
    private static int[] ch;
    private static int[] answer;
    private static int cnt;

    public static void main(String[] args) {
        init();
        int num = convertToDecimal();
        convertToDecimalB(num);
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = cnt - 1; i >=0 ; i--) {
            System.out.print(answer[i]);
        }
    }

    private static void convertToDecimalB(int num) {
        cnt = 0;
        while (true) {
            if (num < b) {
                answer[cnt++] = num;
                break;
            }
            answer[cnt++] = num % b;
            num /= b;
        }
    }

    private static int convertToDecimal() {
        int sum = 0;

        for (int i = 0; i < ch.length; i++) {
            sum = sum * a + ch[i];
        }
        return sum;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        n = input.next();
        ch = new int[n.length()];
        answer = new int[30];

        for (int i = 0; i < ch.length; i++) {
            ch[i] = n.charAt(i) - '0';
        }
    }
}
