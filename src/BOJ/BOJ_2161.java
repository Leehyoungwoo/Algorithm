package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2161 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		Queue<Integer> que = new LinkedList<>();
		int[] out = new int[N - 1];
		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			que.add(i + 1);
		}

		while (que.size() > 1) {
			out[cnt] = que.remove();
			int y = que.poll();
			que.add(y);
			cnt++;
		}

		for (int i = 0; i < out.length; i++) {
			sb.append(out[i]).append(" ");
		}
		sb.append(que.peek());
		System.out.println(sb);
	}
}