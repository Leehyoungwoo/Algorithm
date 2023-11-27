package codetree.intermediateLow.backTracking;

import java.io.*;
import java.util.*;

public class MaxTheMin2 {

	private static int n;
	private static int[][] map;
	private static int answer;
	private static List<Integer> num;

	public static void main(String[] args) throws IOException {
		init();
		dfs(0);
		System.out.println(answer);
	}

	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		answer = 0;
		num = new ArrayList<>();

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
	}

	private static void dfs(int idx) {
		if (idx == n) {
			int minNum = findMinNum();
			answer = Math.max(answer, minNum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!num.contains(i)) {
				num.add(i);
				dfs(idx + 1);
				num.remove(num.size() - 1);
			}
		}
	}

	private static int findMinNum() {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			min = Math.min(min, map[i][num.get(i)]);
		}
		
		return min;
	}
}
