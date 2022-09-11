package array;

import java.util.Scanner;

 

public class Square {

 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int a = input.nextInt();

		int b = input.nextInt();

		int[][] arr = new int[a][b];

		int contents = 1;

		for (int i = 0; i < a + b - 1; i++) {

			for (int j = 0; j < arr.length; j++) {

				b = i - a;

				if (b >= 0 && b <= b) {

					contents++;

					arr[i][j] +=contents;

				}

			}

		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				System.out.print(arr[i][j] + "\t");

			}

			System.out.println();

		}

	}

}