package swExpertAcademy.algorithmTrackD1;

import java.util.*;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        if( a==3 && b==1 || a < b) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }

    }
}
