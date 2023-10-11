package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5607 {

    private static final int MOD = 1234567891;
    private static int T;
    private static int N;
    private static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init(input);
            long ans = findAnswer();
            answer.append("#").append(tc).append(' ').append(ans).append("\n");
        }

        System.out.println(answer);
    }

    private static void init(BufferedReader input) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());
    }

    private static long findAnswer() {
        /// n * (n - 1).... (n - r + 1)
        long A = 1;
        for (int i = N; i >= N - R + 1; i--) {
            A = (A * (i % MOD)) % MOD;
        }

        /// r!
        long B = 1;
        for (int i = 1; i <= R; i++) {
            B = (B * (i % MOD)) % MOD;
        }

        B = power(B, MOD - 2);

        return (A * B) % MOD;
    }

    private static long power(long B, int M) {
        if (M == 0) {
            return 1;
        }
        long result = 1;
        while (M > 0) {
            if (M % 2 == 1) {
                result = (result * B) % MOD;
            }
            B = (B * B) % MOD;
            M /= 2;
        }

        return result;
    }
}