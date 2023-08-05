package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_0804 {

    private static Queue<Integer> password = new LinkedList<>();
    private static final int TEST_CASE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TEST_CASE; tc++) {
            int TC = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                password.add(Integer.parseInt(st.nextToken()));
            }
            sb.append("#").append(TC).append(" ").append(findAnswer()).append("\n");
            password.clear();
        }

        System.out.println(sb);
    }

    private static StringBuilder findAnswer() {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (!isPasswordFormat()) {
            num++;
            if (password.peek() - num < 0) {
                password.poll();
                password.add(0);
                continue;
            }
            password.add(password.poll() - num);
            if (num == 5) {
                num = 0;
            }
        }

        for (int p : password) {
            sb.append(p).append(" ");
        }

        return sb;
    }

    private static boolean isPasswordFormat() {
        for (int num : password) {
            if (num >= 10) {
                return false;
            }
        }
        if (password.contains(0)) {
            return true;
        }

        return false;
    }
}
