package codetree.simulation1;

import java.util.*;

public class FindTheDay {

    private static int gap;
    private static int m1, d1, m2, d2;
    private static int[] monthByDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] weekDay = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public static void main(String[] args) {
        init();
        gap = dayCount();
        printWeakDay();
    }

    private static void printWeakDay() {
        int idx = ((gap % 7) +1) % 7;
        if (gap < 0) {
            idx = ((gap + 7) % 7 + 1) % 7;
        }
        System.out.println(weekDay[idx]);
    }

    private static int dayCount() {
            int sum1 = d1;
            int sum2 = d2;
            for(int i = 1; i < m1; i++) {
                sum1 += monthByDays[i];
            }
            for(int i = 1; i < m2; i++) {
                sum2 += monthByDays[i];
            }
            return sum2 - sum1;
        }


    private static void init() {
        Scanner input = new Scanner(System.in);
        m1 = input.nextInt();
        d1 = input.nextInt();
        m2 = input.nextInt();
        d2 = input.nextInt();
    }
}
