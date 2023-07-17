package codetree.splitByCase;

import java.util.*;

public class TwoSegments {

    private static int x1, x2, x3, x4;
    private static int[] line = new int[100+1];
    public static void main(String[] args) {
        init();
        printAnswer();
    }

    private static void printAnswer() {
        boolean inter = false;
        for(int i = 0; i < line.length; i++) {
            if(line[i] == 2) {
                inter = true;
            }
            if(x2 == x3) {
                inter = true;
            }
            if(x1 == x4) {
                inter = true;
            }
        }
        if(inter) {
            System.out.print("intersecting");
        } else {
            System.out.print("nonintersecting");
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        x1 = input.nextInt();
        x2 = input.nextInt();
        x3 = input.nextInt();
        x4 = input.nextInt();

        for(int i = x1; i < x2; i++) {
            line[i]++;
        }

        for(int i = x3; i < x4; i++) {
            line[i]++;
        }
    }
}