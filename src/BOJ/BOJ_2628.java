package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2628 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int cut = input.nextInt();
		Queue<Integer> row = new LinkedList<>();
		Queue<Integer> col = new LinkedList<>();
		row.add(0);
		row.add(x);
		col.add(0);
		col.add(y);
		int cnt = 0;

		for (int i = 0; i < cut; i++) {
			int type = input.nextInt();
			int num = input.nextInt();
			if (type == 0) {
				col.add(num);
			}
			if (type == 1) {
				row.add(num);
				cnt++;
			}
		}
		int[] xPoint = new int[cnt + 2];
		int[] yPoint = new int[cut - cnt + 2];
		for (int i = 0; i < xPoint.length; i++) {
			xPoint[i] = row.poll();
		}
		for (int i = 0; i < yPoint.length; i++) {
			yPoint[i] = col.poll();
		}
		Arrays.sort(xPoint);
		Arrays.sort(yPoint);
		int[] xLong = new int[cnt + 1];
		int[] yLong = new int[cut - cnt + 1];
		for (int i = 0; i < xLong.length; i++) {
			xLong[i] = xPoint[i + 1] - xPoint[i];
		}
		for (int i = 0; i < yLong.length; i++) {
			yLong[i] = yPoint[i + 1] - yPoint[i];
		}
		Arrays.sort(xLong);
		Arrays.sort(yLong);
		System.out.println(xLong[cnt] * yLong[cut - cnt]);
	}
}