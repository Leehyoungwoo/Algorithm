package codetree.simulation1;

import java.util.*;

public class TimeToTime {

    private static int startHour;
    private static int startMin;
    private static int endHour;
    private static int endMin;
    private static int timeGap;

    public static void main(String[] args) {
        init();
        timeGap = calculateTimeGap();
        System.out.println(timeGap);
    }

    private static int calculateTimeGap() {
        return (endHour * 60 + endMin) - (startHour * 60 + startMin);
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        startHour = input.nextInt();
        startMin = input.nextInt();
        endHour = input.nextInt();
        endMin = input.nextInt();
    }
}
