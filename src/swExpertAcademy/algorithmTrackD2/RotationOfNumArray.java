package swExpertAcademy.algorithmTrackD2;

import java.util.*;

public class RotationOfNumArray {

    private static int T;
    private static int N;
    private static int[][] nums;
    private static String[][] answer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        for(int t = 0; t < T; t++) {
            N = input.nextInt();
            nums = new int[N][N];
            answer = new String[N][3];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    nums[i][j] = input.nextInt();
                }
            }
            System.out.println("#" + (t + 1));
            for (int i = 0; i < 3; i++) {
                nums = rotate90D();
                putToAnswer(i);
            }
            printAnswer();
        }
    }

    private static void printAnswer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(answer[i][j].length() != N) {
                    makeFullSentence(i, j);
                    continue;
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void makeFullSentence(int x, int y) {
        int zeroStartNum = zeroStart(x,y);

        for(int i = 0; i <zeroStartNum; i++) {
            System.out.print('0');
        }

        System.out.print(answer[x][y] + " ");
    }

    private static int zeroStart(int x, int y) {
        return N - answer[x][y].length();
    }

    private static void putToAnswer(int n) {
        for (int i = 0; i < N; i++) {
            answer[i][n] = sumAllRow(i);
        }
    }

    private static String sumAllRow(int n) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum * 10 + nums[n][i];
        }
        return String.valueOf(sum);
    }

    private static int[][] rotate90D() {
        int[][] rotatedNums = new int[N][N];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                rotatedNums[j][N - 1 - i] = nums[i][j];
            }
        }
        return rotatedNums;
    }
}

