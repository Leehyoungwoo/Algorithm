package codetree.simulation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Bead implements Comparable<Bead> {
    int r;
    int c;
    char d;
    int w;
    int num;

    public Bead(int r, int c, char d, int w, int num) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.w = w;
        this.num = num;
    }

    @Override
    public int compareTo(Bead target) {
        if(this.r == target.r) {
            if(this.c == target.c) {
                return Integer.compare(target.num, this.num);
            } else {
                return Integer.compare(this.c, target.c);
            }
        } else {
            return Integer.compare(this.r, target.r);
        }
    }

}


public class BeadsComingTogether {

    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n;
    private static int m;
    private static int t;
    private static List<Bead> beads;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        t = Integer.parseInt(tokenizer.nextToken());

        beads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] str = input.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            char d = str[2].charAt(0);
            int t = Integer.parseInt(str[3]);
            beads.add(new Bead(r, c, d, t, i + 1));
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < t; i++) {
            for (Bead bead : beads) {
                int dir = decideDirection(bead);
                int nextR = bead.r + direction[dir][0];
                int nextC = bead.c + direction[dir][1];
                if (!isInRange(nextR, nextC)) {
                    changeDirection(bead);
                }
                bead.r += direction[dir][0];
                bead.c += direction[dir][1];
            }
            combineSamePositionBeads();
        }
    }

    private static void combineSamePositionBeads() {
        Collections.sort(beads);
        for (int i = 1; i < beads.size(); i++) {
            Bead a = beads.get(i);
            Bead b = beads.get(i - 1);
            if (isSamePosition(a, b)) {
                b.w += a.w;
                beads.remove(a);
                i--;
            }
        }
    }

    private static boolean isSamePosition(Bead a, Bead b) {
        return a.r == b.r && a.c == b.c;
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    private static void changeDirection(Bead bead) {
        char dir = bead.d;
        if (dir == 'U') {
            bead.d = 'D';
            return;
        }
        if (dir == 'D') {
            bead.d = 'U';
            return;
        }
        if (dir == 'L') {
            bead.d = 'R';
            return;
        }
        if (dir == 'R') {
            bead.d = 'L';
        }
    }

    private static int decideDirection(Bead bead) {
        if (bead.d == 'U') {
            return 0;
        }
        if (bead.d == 'D') {
            return 1;
        }
        if (bead.d == 'L') {
            return 2;
        }

        return 3;
    }

    private static void printAnswer() {
        StringBuilder answer = new StringBuilder();
        answer.append(beads.size()).append(" ").append(findMaxWeightBead());
        System.out.println(answer);
    }

    private static int findMaxWeightBead() {
        int max = 0;
        for (Bead bead : beads) {
            max = Math.max(bead.w, max);
        }

        return max;
    }
}
