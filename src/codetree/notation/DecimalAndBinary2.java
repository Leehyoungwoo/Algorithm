package codetree.notation;

import java.util.*;

public class DecimalAndBinary2 {

    private static String N;
    private static char[] ch;
    private static int[] binary;

    private static int[] answer;
    private static int cnt;

    public static void main(String[] args) {
        init();
        int n = convertToDecimal();
        convertToBinary(n * 17);
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = cnt -1 ; i >= 0; i--) {
            System.out.print(answer[i]);
        }
    }

    private static void convertToBinary(int n) {
        cnt = 0;
        while (true) {
            if (n < 2) {
                answer[cnt++] = n;
                break;
            }
            answer[cnt++] = n % 2;
            n /= 2;
        }
    }

    private static int convertToDecimal() {
        int sum = 0;
        for (int i = 0; i < binary.length; i++) {
            sum = sum * 2 + binary[i];
        }
        return sum;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.next();
        ch = new char[N.length()];
        binary = new int[ch.length];
        answer = new int[100];

        for (int i = 0; i < N.length(); i++) {
            ch[i] = N.charAt(i);
        }

        for (int i = 0; i < ch.length; i++) {
            binary[i] = ch[i] - '0';
        }
    }
}
