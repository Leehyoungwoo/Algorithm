package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.Scanner;

public class D3_0801 {

    private static int T;
    private static int N;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();
        for (int t = 0; t < T; t++) {
            init(input);
            System.out.println("#" + (t+1) + " " + harvest());
        }

    }

    private static int harvest() {
        int sum = 0;
        int middle = N / 2;

        for (int i = 0; i <= middle; i++) {
            for (int j = middle - i; j <= middle + i; j++) {
                sum+=map[i][j];
            }
        }

        for (int i = middle + 1; i < map.length; i++) {
            for (int j = i - middle; j < 2 * middle + 1 - (i - middle); j++) {
                sum+=map[i][j];
            }
        }

        return sum;
    }

    private static void init(Scanner input) {
        N = input.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = input.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }
}