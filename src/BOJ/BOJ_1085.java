package BOJ;

import java.util.Scanner;

public class BOJ_1085 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int w = input.nextInt();
		int h = input.nextInt();
		int answer = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		cnt1 = Math.min(x, w - x);
		cnt2 = Math.min(y, h - y);
		answer = Math.min(cnt1, cnt2);
		System.out.println(answer);
	}
}