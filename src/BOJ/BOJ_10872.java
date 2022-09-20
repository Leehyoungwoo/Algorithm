package BOJ;

import java.util.Scanner;

public class BOJ_10872 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int temp = 1;
		int N = input.nextInt();
		for (int i = 1; i <= N; i++) {
			temp = temp * i;
		}
		System.out.println(temp);
	}
}
