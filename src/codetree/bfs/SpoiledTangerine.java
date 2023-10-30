import java.util.*;
import java.io.*;

public class SpoiledTangerine {

	private static final int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int n;
	private static int k;
	private static int[][] map;
	private static Integer[][] timeMap;
	private static List<int[]> rotten;

	public static void main(String[] args) throws IOException {
		init();
		makingTimeMap();
		printTimeMap();
	}

	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());

		rotten = new ArrayList<>();
		timeMap = new Integer[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
				if (map[i][j] == 2) {
					rotten.add(new int[] { i, j, 0 });
				}
			}
		}
	}

	private static void makingTimeMap() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(timeMap[i], Integer.MAX_VALUE);
		}
		fillZeroToMinusOne();
		int time = 0;
		for (int[] rot : rotten) {
			bfs(rot);
		}
		
		for (int[] rot : rotten) {
			timeMap[rot[0]][rot[1]] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && timeMap[i][j] == Integer.MAX_VALUE) {
					timeMap[i][j] = -2;
				}
			}
		}
	}

	private static void bfs(int[] rot) {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> que = new LinkedList<>();
		visited[rot[0]][rot[1]] = true;
		que.offer(rot);
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int curR = cur[0];
			int curC = cur[1];
			int time = cur[2] + 1;
			for (int[] dir : direction) {
				int nextR = curR + dir[0];
				int nextC = curC + dir[1];
				if (isInRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
					visited[nextR][nextC] = true;
					que.offer(new int[] { nextR, nextC, time });
					timeMap[nextR][nextC] = Math.min(timeMap[nextR][nextC], time);
				}
			}
		}
		
		
	}

	private static void fillZeroToMinusOne() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					timeMap[i][j] = -1;
				}
			}
		}
	}

	private static boolean isInRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	private static void printTimeMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(timeMap[i][j] + " ");
			}

			System.out.println();
		}
	}

}
