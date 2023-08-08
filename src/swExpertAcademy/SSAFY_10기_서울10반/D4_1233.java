package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.*;

class Node {
    String data;
    int num;

    int left;
    int right;

    public Node(String data, int num) {
        this.data = data;
        this.num = num;
    }
}

public class D4_1233 {

    private static int TEST_CASE = 10;
    private static int n;
    private static Node[] nodes;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner input = new Scanner(System.in);

        for (int tc = 1; tc <= TEST_CASE; tc++) {
            init(input);

            try {
                findAnswer(1);
                sb.append("#").append(tc).append(" ").append(1);
            } catch (Exception e) {
                sb.append("#").append(tc).append(" ").append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int findAnswer(int idx) {
        if (nodes[idx].right == 0 && nodes[idx].left != 0) {
            throw new RuntimeException();
        }
        if (nodes[idx].left == 0) {
            return Integer.parseInt(nodes[idx].data);
        }
        int left = findAnswer(nodes[idx].left);
        int right = findAnswer(nodes[idx].right);

        return -1;
    }

    private static void init(Scanner input) {
        n = Integer.parseInt(input.nextLine());
        nodes = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            String[] s = input.nextLine().split(" ");

            int idx = Integer.parseInt(s[0]);
            String data = s[1];
            nodes[idx] = new Node(data, idx);

            if (s.length >= 3) {
                nodes[idx].left = Integer.parseInt(s[2]);
                if (s.length == 4) {
                    nodes[idx].right = Integer.parseInt(s[3]);
                }
            }
        }
    }
}