package swExpertAcademy.algorithmTrackD1;

import java.util.*;

public class AddOddNums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] arr = new int[10];


        for (int i = 0; i < T; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                arr[j] = input.nextInt();
                if (arr[j] % 2 != 0) {
                    sum += arr[j];
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
