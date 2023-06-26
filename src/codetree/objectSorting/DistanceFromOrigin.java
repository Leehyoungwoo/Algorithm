package codetree.objectSorting;

import java.util.*;

public class DistanceFromOrigin {

    private static int n;
    private static Point[] points;

    static class Point {
        int xP;
        int yP;
        int num;

        public Point(int xP, int yP, int num) {
            this.xP = xP;
            this.yP = yP;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if(Math.abs(a.xP) + Math.abs(a.yP) == Math.abs(b.xP) + Math.abs(b.yP)) {
                    return a.num - b.num;
                }
                return (Math.abs(a.xP) + Math.abs(a.yP)) - (Math.abs(b.xP) + Math.abs(b.yP));
            }
        });
        printAll();
    }

    private static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(points[i].num);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            int xP = input.nextInt();
            int yP = input.nextInt();
            points[i] = new Point(xP, yP, i + 1);
        }
    }
}
