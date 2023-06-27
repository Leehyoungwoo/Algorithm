package codetree.simulation1;

import java.util.*;

public class ThatDay {

    private static int m1,d1,m2,d2;
    private static int[] monthByDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] weekDay = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat" , "Sum"};
    private static String thatDay;


    public static void main(String[] args) {
        init();
        int gap = calculateDay();
        int answer = dayCount(gap);
        System.out.println(answer);

    }

    private static int dayCount(int gap) {
        return 0;
    }

    private static int calculateDay() {
        int sum1 = d1;
        for(int i = 1; i < m1; i++) {
            sum1 += monthByDays[i];
        }
        int sum2 = d2;
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
        thatDay = input.next();
    }
}
