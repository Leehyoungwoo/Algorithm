package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int[] dwarf = new int[9];
		int sum = 0;
		int liar1 = 0;
		int liar2 = 0;

		for (int i = 0; i < 9; i++) {
			int x = input.nextInt();
			dwarf[i] = x;
			sum += dwarf[i];
		}

		for (int i = 0; i < dwarf.length; i++) {

			for (int j = i + 1; j < dwarf.length; j++) {
				sum -= (dwarf[i] + dwarf[j]);
				if (sum == 100) {
					liar1 = dwarf[i];
					liar2 = dwarf[j];
				}
				if (sum != 100) {
					sum += (dwarf[i] + dwarf[j]);
				}
			}
		}
		Arrays.sort(dwarf);

		for (int j = 0; j < dwarf.length; j++) {
			if (dwarf[j] != liar1 && dwarf[j] != liar2) {
				System.out.println(dwarf[j]);
			}
		}
	}
}