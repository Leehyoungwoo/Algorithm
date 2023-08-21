package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Enemy {
    int r;
    int c;

    public Enemy(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Enemy)) {
            return false;
        }

        Enemy that = (Enemy) o;
        return this.r == that.r && this.c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}

public class BOJ_17135 {

    private static int n;
    private static int m;
    private static int d;
    private static int[][] map;
    private static int max = 0;
    private static int[] position;
    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        findArcherPosition(0, 0);
        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        d = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        position = new int[3];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer tokenizer1 = new StringTokenizer(input.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(tokenizer1.nextToken());
                if (map[i][j] == 1) {
                    enemies.add(new Enemy(i, j));
                }
            }
        }
    }

    private static void findArcherPosition(int idx, int start) {
        if (idx == 3) {
            max = Math.max(max, findKillingEnemyCnt(copyList()));
            return;
        }

        if (start == m) {
            return;
        }

        position[idx] = start;
        findArcherPosition(idx + 1, start + 1);
        findArcherPosition(idx, start + 1);
    }

    private static ArrayList<Enemy> copyList() {
        ArrayList<Enemy> list = new ArrayList<>();

        for (Enemy enemy : enemies) {
            list.add(enemy);
        }

        return list;
    }

    private static int findKillingEnemyCnt(ArrayList<Enemy> enemies) {
        int cnt = 0;
        int archerRow = n + 1;

        while (archerRow-- > 0 && !enemies.isEmpty()) {
            Set<Enemy> choicedEnemy = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                // 각 궁수의 제일 가까운 적을 찾기
                int lowestDisEnemy = findMinDistance(archerRow, position[i], enemies);

                Enemy target = null;
                for (Enemy enemy : enemies) {
                    if (target == null && calculateDistance(enemy, archerRow, position[i]) == lowestDisEnemy) {
                        target = enemy;
                        continue;
                    }

                    if (target != null && calculateDistance(enemy, archerRow, position[i]) == lowestDisEnemy && target.c > enemy.c) {
                        target = enemy;
                    }
                }

                if (target != null) {
                    choicedEnemy.add(target);
                }
            }

            // 같은 적을 동시에 쏠 수 있기 때문에 모든 궁수가 적을 선택한 후 Set을 사용해 중복 제거 후 제거
            cnt += choicedEnemy.size();
            enemies.removeAll(choicedEnemy);

            // 매번 끝 줄에 있는 적들 사라짐
            List<Enemy> safe = new ArrayList<>();
            for (Enemy enemy : enemies) {
                if (enemy.r == archerRow - 1) {
                    safe.add(enemy);
                }
            }
            enemies.removeAll(safe);
        }

        return cnt;
    }

    private static int findMinDistance(int archerRow, int c, ArrayList<Enemy> enemies) {
        int min = Integer.MAX_VALUE;

        for (Enemy enemy : enemies) {
            int distance = calculateDistance(enemy, archerRow, c);
            if (distance <= d) {
                min = Math.min(min, distance);
            }
        }

        return min;
    }

    // 각 적의 위치를 계산
    private static int calculateDistance(Enemy enemy, int r, int c) {
        return Math.abs(r - enemy.r) + Math.abs(c - enemy.c);
    }
}