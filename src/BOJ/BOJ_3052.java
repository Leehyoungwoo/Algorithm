package BOJ;

import java.util.Scanner;

public class BOJ_3052 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = input.nextInt() % 42;
		}
		int count = 0;
		boolean[] visited = new boolean[42];
		for (int num : arr) {
			if (!visited[num]) {
				visited[num] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}