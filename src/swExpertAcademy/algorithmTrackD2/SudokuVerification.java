package swExpertAcademy.algorithmTrackD2;

import java.util.*;

public class SudokuVerification {
    private static int[][] sudoku = new int[10][10];
    private static int T;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        for (int i = 0; i < T; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    sudoku[j][k] = input.nextInt();
                }
            }
            printAnswer(i + 1);
        }
    }

    private static void printAnswer(int n) {
        if (isPerfectSudoku()) {
            System.out.println("#" + n + " " + 1);
        } else {
            System.out.println("#" + n + " " + 0);
        }
    }

    private static boolean isPerfectSudoku() {
        return isLineRight() && isSmallRecRight();
    }

    private static boolean isSmallRecRight() {
        for (int i = 1; i <= 7; i += 3) {
            for (int j = 1; j <= 7; j += 3) {
                if (!isSmallRec(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSmallRec(int row, int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = sudoku[i][j];
                if (num != 0) {
                    if (set.contains(num)) {
                        return false;
                    }
                    set.add(num);
                }
            }
        }
        return true;
    }

    private static boolean isLineRight() {
        for (int i = 1; i <= 9; i++) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> set1 = new HashSet<>();
            for (int j = 1; j <= 9; j++) {
                int num = sudoku[i][j];
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
                int num1 = sudoku[j][i];
                if (set1.contains(num1)) {
                    return false;
                }
                set1.add(num1);
            }
        }
        return true;
    }
}