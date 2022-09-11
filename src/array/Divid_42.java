package array;

import java.util.Scanner;

 

public class Divid_42 {

 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int[] arr = new int[10];

		int count = 0;

 

		for (int i = 0; i < arr.length; i++) {

			arr[i] = input.nextInt();

			int div = arr[i] % 42;

 

			for (int j = 0; j < arr.length; j++) {

				for (int j2 = 0; j2 < arr.length; j2++) {

					if (arr[j] == arr[j2]) {

						count++;

					} else {

						break;

					}

				}

			}

		}

	}

 

}


