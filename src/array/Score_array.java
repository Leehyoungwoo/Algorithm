package array;

import java.util.Scanner;

 

public class Score_array {

 

	public static void main(String[] args) {

 

		Scanner input = new Scanner(System.in);

		int count_100 = 0;

		int count_90 = 0;

		int count_80 = 0;

		int count_70 = 0;

		int count_60 = 0;

		int count_50 = 0;

		int count_40 = 0;

		int count_30 = 0;

		int count_20 = 0;

		int count_10 = 0;

 

		while (true) {

			int score = input.nextInt();

			if (score == 100) {

				count_100++;

			} else if (90 <= score && score < 100) {

				count_90++;

			} else if (80 <= score && score < 90) {

				count_80++;

			} else if (70 <=score && score < 80) {

				count_70++;

			} else if (60 <= score && score < 70) {

				count_60++;

			} else if (50 <= score && score < 60) {

				count_50++;

			} else if (40 <= score && score < 50) {

				count_40++;

			} else if (30 <= score && score < 40) {

				count_30++;

			} else if (20 <= score && score < 30) {

				count_20++;

			} else if (10 <= score && score < 20) {

				count_10++;

			} else if (score==0) {

				break;

			}

		}

		System.out.println("100 - "+ count_100);

		System.out.println("90 - "+count_90);

		System.out.println("80 - "+count_80);

		System.out.println("70 - "+count_70);

		System.out.println("60 - "+count_60);

		System.out.println("50 - "+count_50);

		System.out.println("40 - "+count_40);

		System.out.println("30 - "+count_30);

		System.out.println("20 - "+count_20);

		System.out.println("10 - "+count_10);

	}

 

}