package BOJ;

import java.util.Scanner;

public class BOJ_4344 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();


		for (int i = 0; i < testCase; i++) {
			int N = input.nextInt();
			int[] arr = new int[N];
			double sum = 0;
			
			for (int j = 0; j < N; j++) {
				arr[j] = input.nextInt();
				sum += arr[j];
			}
			double avg = (sum / N);
			double cnt = 0;

			for (int k = 0; k < arr.length; k++) {
				if (arr[k] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", (cnt / N) * 100);
		}

	}
}