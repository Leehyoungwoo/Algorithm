import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillRectangle {

	private static int MOD = 10_007;
	private static int n;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;
		}

		System.out.println(dp[n]);
	}
}
