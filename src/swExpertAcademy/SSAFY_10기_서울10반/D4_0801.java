package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.Scanner;

public class D4_0801 {

    private static final int SIZE = 100;
    private static final int TEST_CASE = 10;
    private static int[][] map = new int[SIZE][SIZE];

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);

        for (int tc = 1; tc <= TEST_CASE; tc++) {
            init(input);
            System.out.println("#" + tc + " " + findX(0));
        }
    }

    private static int findX(final int cur) {
        return findX(cur, new boolean[SIZE][SIZE]);
    }

    private static int findX(final int curCol, final boolean[][] visited) {
        if (curCol == SIZE) {
            return -1;
        }

        if (map[0][curCol] == 0) {
            return findX(curCol + 1, new boolean[SIZE][SIZE]);
        }

        if (isX(curCol, visited)) {
            return curCol;
        }

        return findX(curCol + 1, new boolean[SIZE][SIZE]);
    }

    private static boolean isX(final int curCol, final boolean[][] visited) {
        int row = 0;
        int col = curCol;

        while (row < SIZE) {
            visited[row][col] = true;

            if (isBottom(row) && map[row][col] == 2) {
                return true;
            }

            if (canMove(row, col + 1, visited)) {
                col++;
                continue;
            }

            if (canMove(row, col - 1, visited)) {
                col--;
                continue;
            }

            row++;
        }

        return false;
    }

    private static boolean isBottom(final int row) {
        return row == SIZE - 1;
    }

    private static boolean canMove(final int row, final int col, final boolean[][] visited) {
        return isInRange(col) && !visited[row][col] && map[row][col] == 1;
    }

    private static boolean isInRange(final int nextCol) {
        return 0 <= nextCol && nextCol < SIZE;
    }

    private static void init(final Scanner input) {
        input.nextInt();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }
}
