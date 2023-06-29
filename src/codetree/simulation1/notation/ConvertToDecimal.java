package codetree.simulation1.notation;

import java.util.*;

public class ConvertToDecimal {

    private static int[] binary = new int[8];
    private static char[] chr;

    public static void main(String[] args) {
        init();
        int sum = convertToDecimal();
        System.out.println(sum);
    }

    private static int convertToDecimal() {
        int sum = 0;
        for (int i = 0; i < chr.length; i++) {
            sum = sum * 2 + binary[i];
        }
        return sum;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        String n = input.next();
        chr = new char[n.length()];

        for (int i = 0; i < n.length(); i++) {
            chr[i] = n.charAt(i);
        }

        for (int i = 0; i < n.length(); i++) {
            binary[i] = chr[i] - '0';
        }
    }
}
