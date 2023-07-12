package codetree.simulation2;

import java.util.*;

public class AddAllNumbersAlongThePath {

    private static int N;
    private static int T;
    private static int[][] map;
    private static int Ox;
    private static int Oy;
    private static char[] order;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static char status = 'N';

    public static void main(String[] args) {
        init();
        System.out.print(moveSum());
    }

    private static int moveSum() {
        int sum = map[Ox][Oy];

        for (int i = 0; i < order.length; i++) {
            if (order[i] == 'F' && !isValid(i)) {
                continue;
            }

            if (order[i] == 'F') {
                move();
                sum += map[Oy][Ox];
            } else if (order[i] == 'L') {
                changeStatusL();
            } else if (order[i] == 'R') {
                changeStatusR();
            }
        }

        return sum;
    }

    private static boolean isValid(int n) {
        int nextX = 0;
        int nextY = 0;

        if (status == 'E') {
            nextX = Ox + dx[0];
            nextY = Oy + dy[0];
        } else if (status == 'W') {
            nextX = Ox + dx[1];
            nextY = Oy + dy[1];
        } else if (status == 'S') {
            nextX = Ox + dx[2];
            nextY = Oy + dy[2];
        } else if (status == 'N') {
            nextX = Ox + dx[3];
            nextY = Oy + dy[3];
        }

        return 0 <= nextX && nextX < N && 0 <= nextY && nextY < N;
    }

    private static void move() {
        if (status == 'E') {
            Ox += dx[0];
            Oy += dy[0];
        } else if (status == 'W') {
            Ox += dx[1];
            Oy += dy[1];
        } else if (status == 'S') {
            Ox += dx[2];
            Oy += dy[2];
        } else if (status == 'N') {
            Ox += dx[3];
            Oy += dy[3];
        }
    }

    private static void changeStatusL() {
        if (status == 'N') {
            status = 'W';
        } else if (status == 'W') {
            status = 'S';
        } else if (status == 'S') {
            status = 'E';
        } else if (status == 'E') {
            status = 'N';
        }
    }

    private static void changeStatusR() {
        if (status == 'N') {
            status = 'E';
        } else if (status == 'E') {
            status = 'S';
        } else if (status == 'S') {
            status = 'W';
        } else if (status == 'W') {
            status = 'N';
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        T = input.nextInt();
        map = new int[N][N];
        Ox = N / 2;
        Oy = N / 2;
        order = new char[T];
        String str = input.next();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = input.nextInt();
            }
        }

        for (int t = 0; t < str.length(); t++) {
            order[t] = str.charAt(t);
        }
    }
}