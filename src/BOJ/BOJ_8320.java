package BOJ;

import java.util.*;

    public class BOJ_8320 {

        private static int n;

        public static void main(String[] args) {
            init();
            System.out.print(answer());
        }

        private static int answer() {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; i * j <= n; j++) {
                    cnt++;
                }
            }
            return cnt;
        }

        private static void init() {
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
        }
    }

