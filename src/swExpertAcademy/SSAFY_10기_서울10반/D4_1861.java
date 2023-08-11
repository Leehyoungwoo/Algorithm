package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.PriorityQueue;
import java.util.Scanner;

class Room implements Comparable<Room>{

    int roomNum;
    int linkedCount;

    public Room(int roomNum, int linkedCount) {
        this.roomNum = roomNum;
        this.linkedCount = linkedCount;
    }

    @Override
    public int compareTo(Room target) {
        if(this.linkedCount > target.linkedCount) {
            return -1;
        } else if(this.linkedCount < target.linkedCount) {
            return 1;
        } else {
            if(this.roomNum < target.roomNum) {
                return -1;
            } else if(this.roomNum > target.roomNum) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    @Override
    public String toString() {
        return Integer.toString(roomNum) + " " + Integer.toString(linkedCount);
    }
}

public class D4_1861 {

    private static int TestCase;
    private static int N;
    private static int[][] map;
    private static PriorityQueue<Room> que = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        TestCase = input.nextInt();

        for (int tc = 1; tc <= TestCase; tc++) {
            init(input);
            pushToQue();
            sb.append("#").append(tc).append(" ").append(que.poll()).append("\n");
            que.clear();
        }
        System.out.println(sb);
    }

    private static void pushToQue() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = findCount(i, j);
                que.add(new Room(map[i][j], count));
            }
        }
    }

    private static int findCount(int y, int x) {
        int count = 1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValidPolicy(x, y, nextX, nextY)) {
                count += findCount(nextY, nextX);
            }
        }

        return count;
    }

    private static boolean isValidPolicy(int x, int y, int nextX, int nextY) {
        return isValidX(nextX) && isValidY(nextY) && map[nextY][nextX] == map[y][x] + 1;
    }

    private static boolean isValidX(int nextX) {
        return 0 <= nextX && nextX < N;
    }

    private static boolean isValidY(int nextY) {
        return 0 <= nextY && nextY < N;
    }

    private static void init(Scanner input) {
        N = input.nextInt();
        map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }
}