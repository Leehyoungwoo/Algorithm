package codetree.object;

import java.util.*;

public class RainyDay {

    private static int n;
    private static Day[] dayArr;

    static class Day {
        String YMD;
        String dayOfWeak;
        String weather;

        public Day(String YMD, String dayOfWeak, String weather) {
            this.YMD = YMD;
            this.dayOfWeak = dayOfWeak;
            this.weather = weather;
        }
    }

    public static void main(String[] args) {
        init();
        printRainyDay();
    }

    private static void printRainyDay() {
        for (int i = 0; i < dayArr.length; i++) {
            if (isRainy(i)) {
                System.out.print(lastRainyDay());
                break;
            }
        }
    }

    private static String lastRainyDay() {
        List<Day> list = new ArrayList<>();

        for(int i = 0; i < dayArr.length; i++) {
            if(isRainy(i)) {
                list.add(dayArr[i]);
            }
        }
        Comparator<Day> comparator = new Comparator<Day>() {
            @Override
            public int compare(Day a, Day b) {
                return a.YMD.compareTo(b.YMD);
            }
        };
        Collections.sort(list, comparator);
        return list.get(0).YMD + " " + list.get(0).dayOfWeak + " " + list.get(0).weather;
    }

    private static boolean isRainy(int i) {
        return dayArr[i].weather.equals("Rain");
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        dayArr = new Day[n];

        for (int i = 0; i < dayArr.length; i++) {
            String ymd = input.next();
            String dayOfWeak = input.next();
            String weather = input.next();
            dayArr[i] = new Day(ymd, dayOfWeak, weather);
        }
    }
}
