import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PpuyoPpuyo {

	private static final int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int ppuyoCnt;
	private static int maxBlockSize;

	public static void main(String[] args) throws IOException {
		init();
		findAnser();
		System.out.println(ppuyoCnt + " " + maxBlockSize);
	}

	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		ppuyoCnt = 0;
		maxBlockSize = 0;

		visited = new boolean[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
	}

	private static boolean isPossibleToMove(int r, int c) {
		return isInRange(r, c) && !visited[r][c];
	}

	private static boolean isInRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	private static void findAnser() {
		int block = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					block = dfs(i, j, 1);
					if (block >= 4) {
						ppuyoCnt++;
					}
					maxBlockSize = Math.max(maxBlockSize, block);

				}
			}
		}
	}

	private static int dfs(int curR, int curC, int block) {
		visited[curR][curC] = true;
		
		for (int[] dir : direction) {
			int nextR = curR + dir[0];
			int nextC = curC + dir[1];
			if (isPossibleToMove(nextR, nextC) && map[nextR][nextC] == map[curR][curC]) {
				block = Math.max(dfs(nextR, nextC, block + 1), block);
			}
		}

		return block;
	}
}
