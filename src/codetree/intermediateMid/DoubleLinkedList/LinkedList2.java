package codetree.intermediateMid.DoubleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Number {
    int cur;
    int prev;
    int next;

    public Number(int cur, int prev, int next) {
        this.cur = cur;
        this.prev = prev;
        this.next = next;
    }
}

public class LinkedList2 {
    private static int n;
    private static int q;
    private static HashMap<Integer, Number> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        q = Integer.parseInt(input.readLine());

        for (int i = 1; i <= n; i++) {
            Number cur = new Number(i, 0, 0);
            map.put(i, cur);
        }

        for (int i = 0; i < q; i++) {
            String[] operation = input.readLine().split(" ");
            int opType = Integer.parseInt(operation[0]);

            switch (opType) {
                case 1:
                    int nodeToRemove = Integer.parseInt(operation[1]);
                    removeNode(nodeToRemove);
                    break;

                case 2:
                    int existingNode = Integer.parseInt(operation[1]);
                    int newNode = Integer.parseInt(operation[2]);
                    insertBefore(newNode, existingNode);
                    break;

                case 3:
                    existingNode = Integer.parseInt(operation[1]);
                    newNode = Integer.parseInt(operation[2]);
                    insertAfter(newNode, existingNode);
                    break;

                case 4:
                    int nodeToPrint = Integer.parseInt(operation[1]);
                    printAdjacentNodes(nodeToPrint);
                    break;
            }
        }

        // 모든 노드의 다음 노드 출력
        for (int i = 1; i <= n; i++) {
            Number cur = map.get(i);
            cur.next = cur.next == 0 ? 0 : cur.next;
            System.out.print(cur.next + " ");
        }
    }

    private static void removeNode(int nodeToRemove) {
        Number cur = map.get(nodeToRemove);
        Number prev = map.get(cur.prev);
        Number next = map.get(cur.next);

        if (prev != null) {
            prev.next = cur.next;
        }
        if (next != null) {
            next.prev = cur.prev;
        }

        cur.prev = 0;
        cur.next = 0;
    }

    private static void insertBefore(int newNode, int existingNode) {
        Number cur = map.get(newNode);
        Number existing = map.get(existingNode);
        Number prevExisting = map.get(existing.prev);

        cur.prev = existing.prev;
        cur.next = existingNode;

        existing.prev = newNode;

        if (prevExisting != null) {
            prevExisting.next = newNode;
        }
    }

    private static void insertAfter(int newNode, int existingNode) {
        Number cur = map.get(newNode);
        Number existing = map.get(existingNode);
        Number nextExisting = map.get(existing.next);

        cur.prev = existingNode;
        cur.next = existing.next;

        existing.next = newNode;

        if (nextExisting != null) nextExisting.prev = newNode;
    }

    private static void printAdjacentNodes(int nodeToPrint) {
        Number cur = map.get(nodeToPrint);
        int prev = cur.prev == 0 ? 0 : cur.prev;
        int next = cur.next == 0 ? 0 : cur.next;
        System.out.println(prev + " " + next);
    }
}
