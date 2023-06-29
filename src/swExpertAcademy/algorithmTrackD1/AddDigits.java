package swExpertAcademy.algorithmTrackD1;

import java.util.*;

public class AddDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String N = input.next();
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum += N.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
