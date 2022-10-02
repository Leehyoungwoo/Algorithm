package BOJ;

import java.util.Scanner;

public class BOJ_14696 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] arrA = new int[4];
		int[] arrB = new int[4];
		String[] answer = new String[N]; ///// 게임의 결과

		for (int i = 0; i < N; i++) {
			int a = input.nextInt();

			for (int j = 0; j < a; j++) {
				int x = input.nextInt();
				arrA[x - 1]++;
			}

			int b = input.nextInt();
			for (int j = 0; j < b; j++) {
				int y = input.nextInt();
				arrB[y - 1]++;
			} /////// a,b의 카드까지느 입력 잘됨

			for (int k = 3; k >= 0; k--) {
				if (arrA[k] == arrB[k]) {
				}
				if (arrA[k] != arrB[k]) {
					if (arrA[k] > arrB[k]) {
						answer[i] = "A";
					}
					if (arrA[k] < arrB[k]) {
						answer[i] = "B";
					}
					break;
				}
				if (arrA[0] == arrB[0]) {
					answer[i] = "D";
				}
			}
			
			for (int j = 0; j < arrA.length; j++) {
				arrA[j] = 0;
				arrB[j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}
}