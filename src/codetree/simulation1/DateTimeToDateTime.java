package codetree.simulation1;

import java.util.*;


public class DateTimeToDateTime {

    private static int a;
    private static int b;
    private static int c;
    private static int minGap;

    public static void main(String[] args) {
        init();
        minGap = TotalMinCalculate();
        isValidTime();

    }

    private static int TotalMinCalculate() {
        return ((a * 24 * 60) + (b * 60) + c) - ((11 * 24 * 60) + (11 * 60) + 11);
    }

    private static void isValidTime() {
        if (isNotValid()) {
            System.out.println(-1);
        } else {
            System.out.println(minGap);

        }
    }

    private static boolean isNotValid() {
        if (TotalMinCalculate() < 0) {
            return true;
        }
        return false;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
    }
}
