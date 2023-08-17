package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tank {
    char dir;
    int row;
    int col;

    public Tank(char dir, int row, int col) {
        this.dir = dir;
        this.row = row;
        this.col = col;
    }
}

public class D3_1873 {

    private static int testCase;
    private static int height;
    private static int width;
    private static char[][] map;
    private static int n;
    private static char[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            init(input);
            Tank tank = makingTank();
            followOrder(tank);
            sb.append("#").append(tc).append(" ").append(mapStatus());
        }

        System.out.println(sb);
    }

    private static Tank makingTank() {
        char dir = '0';
        int row = 0;
        int col = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '<') {
                    dir = 'L';
                    row = i;
                    col = j;
                    break;
                }

                if(map[i][j] == '>') {
                    dir = 'R';
                    row = i;
                    col = j;
                    break;
                }

                if(map[i][j] == '^') {
                    dir = 'U';
                    row = i;
                    col = j;
                    break;
                }

                if(map[i][j] == 'v') {
                    dir = 'D';
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        return new Tank(dir, row, col);
    }

    private static StringBuilder mapStatus() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        return sb;
    }

    private static void followOrder(Tank tank) {
        for (int i = 0; i < order.length; i++) {
            moving(tank, order[i]);
        }
    }

    private static void moving(Tank tank, char order) {
        switch (order) {

            case 'U':
                tank.dir = 'U';
                if(isInrangeRow(tank.row - 1, tank.col) && isPungJi(tank.row - 1, tank.col)) {
                    map[tank.row][tank.col] = '.';
                    tank.row--;
                    map[tank.row][tank.col] = '^';
                } else {
                    map[tank.row][tank.col] = '^';
                }
                break;
            case 'D':
                tank.dir = 'D';
                if(isInrangeRow(tank.row + 1, tank.col) && isPungJi(tank.row + 1, tank.col)) {
                    map[tank.row][tank.col] = '.';
                    tank.row++;
                    map[tank.row][tank.col] = 'v';
                } else {
                    map[tank.row][tank.col] = 'v';
                }
                break;
            case 'L':
                tank.dir = 'L';
                if(isInrangeRow(tank.row, tank.col - 1) && isPungJi(tank.row, tank.col -1)) {
                    map[tank.row][tank.col] = '.';
                    tank.col--;
                    map[tank.row][tank.col] = '<';
                } else {
                    map[tank.row][tank.col] = '<';
                }
                break;
            case 'R':
                tank.dir = 'R';
                map[tank.row][tank.col] = '>';
                if(isInrangeRow(tank.row, tank.col + 1) && isPungJi(tank.row, tank.col + 1)) {
                    map[tank.row][tank.col] = '.';
                    tank.col++;
                    map[tank.row][tank.col] = '>';
                } else {
                    map[tank.row][tank.col] = '>';
                }
                break;
            case 'S':
                shooting(tank);
                break;
        }
    }

    private static void shooting(Tank tank) {
        int boomR = tank.row;
        int boomC = tank.col;
        char dir = tank.dir;
        int[] dc = {0, 0, -1, 1};
        int[] dr = {-1, 1, 0, 0};
        int direc = findDir(dir);

        while (isInrangeRow(boomR, boomC)) {
            if(map[boomR][boomC] == '*') {
                map[boomR][boomC] = '.';
                break;
            }

            if(map[boomR][boomC] == '#') {
                break;
            }

            boomR+=dr[direc];
            boomC+=dc[direc];
        }
    }

    private static int findDir(char dir) {
        if(dir == 'U') {
            return 0;
        }
        if(dir == 'D') {
            return 1;
        }
        if(dir == 'L') {
            return 2;
        }
        return 3;
    }

    private static boolean isPungJi(int r, int c) {
        return map[r][c] == '.';
    }

    private static boolean isInrangeRow(int r, int c) {
        return 0 <= r && r < height && 0 <= c && c < width;
    }

    private static void init(BufferedReader input) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());
        map = new char[height][width];

        for (int i = 0; i < map.length; i++) {
            String s = input.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        n = Integer.parseInt(input.readLine());
        order = new char[n];
        String s = input.readLine();
        for (int i = 0; i < order.length; i++) {
            order[i] = s.charAt(i);
        }
    }
}