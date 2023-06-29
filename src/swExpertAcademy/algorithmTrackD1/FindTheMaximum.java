package swExpertAcademy.algorithmTrackD1;

import java.util.*;

public class FindTheMaximum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = input.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("#"+ (i+1) + " " + arr[9]);
        }
    }
}
