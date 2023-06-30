package codetree.simulation2;
import java.util.Scanner;

public class NumberInSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = input.nextInt();
        }

        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < N; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 1;
            }
        }

        System.out.println(maxCount);
    }
}
