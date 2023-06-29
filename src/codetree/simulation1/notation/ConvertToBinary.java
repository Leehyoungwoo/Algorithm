package codetree.simulation1.notation;

import java.util.*;

public class ConvertToBinary {

    private static int n;
    private static int[] binary;
    private static int cnt;

    public static void main(String[] args) {
        init();
        convertToBinary();
        printBinary();
    }

    private static void printBinary() {
        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }

    private static void convertToBinary() {
        cnt = 0;
        while (true) {
            if (n < 2) {
                binary[cnt++] = n;
                break;
            }
            binary[cnt++] = n % 2;
            n /= 2;
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        binary = new int[20];
    }
}
