package codetree.simulatiom1;

import java.util.*;

public class DateToDate {

    private static int m1;
    private static int d1;
    private static int m2;
    private static int d2;
    private static int[] monthByDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int dayGap;

    public static void main(String[] args) {
        init();
        dayGap = calculateDate();
        System.out.println(dayGap);
    }

    private static int calculateDate() {
        int sum1 = d1;
        int sum2 = d2;
        for(int i = 1; i < m1; i++) {
            sum1 += monthByDays[i];
        }
        for(int i = 1; i < m2; i++) {
            sum2 += monthByDays[i];
        }
        return sum2 - sum1 + 1;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        m1 = input.nextInt();
        d1 = input.nextInt();
        m2 = input.nextInt();
        d2 = input.nextInt();
    }
}
