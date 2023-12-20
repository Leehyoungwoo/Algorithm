package codetree.intermediateMid.treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node implements Comparable<Node> {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node target) {
        if (this.x == target.x) {
            return this.y - target.y;
        }

        return this.x - target.x;
    }
}

public class Friendship {

    private static int n;
    private static int m;
    private static TreeSet<Node> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            set.add(new Node(x, y));
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            if(set.ceiling(new Node(x1, y1)) != null) {
                Node cur = set.ceiling(new Node(x1, y1));
                System.out.println(cur.x + " " + cur.y);
                continue;
            }
            System.out.println(-1 + " " + -1);
        }
    }
}
