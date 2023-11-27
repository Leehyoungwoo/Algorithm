import java.util.*;
import java.io.*;

public class PickMPoint {

	private static int n;
	private static int m;
	private static List<int[]> num;
	private static List<Integer> comb;
	private static int answer = 0;
	private static int minLongDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		init();
		dfs(0, 0);
		System.out.println(minLongDistance);
	}

	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		comb = new ArrayList<>();

		num = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			num.add(new int[] { x, y });
		}
	}

	private static void dfs(int idx, int start) {
		if (idx == m) {
//			System.out.println(comb);
			int longDistance = findLongDis();
			minLongDistance = Math.min(minLongDistance, longDistance);
			return;
		}
		
		if (start == n) {
			return;
		}

		comb.add(start);
		dfs(idx + 1, start + 1);
		comb.remove(comb.size() - 1);
		dfs(idx, start + 1);
		
	}

	/// 조합에서 가장 긴 길이의 값을 찾는 메서드
	private static int findLongDis() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < comb.size() - 1; i++) {
			for (int j = i + 1; j < comb.size(); j++) {
				max = Math.max(max, calculateDistance(i, j));
			}
		}

		return max;
	}

	private static int calculateDistance(int i, int j) {
		int[] a = num.get(comb.get(i));
		int[] b = num.get(comb.get(j));

		return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	}
}