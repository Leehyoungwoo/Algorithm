package codetree.intermediateMid.DoubleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
    String value;
    Node prev;
    Node next;

    public Node(String value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LinkedList1 {
    static Node cur;
    static Map<String, Node> nodeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S_init = br.readLine();
        int N = Integer.parseInt(br.readLine());

        cur = new Node(S_init);
        nodeMap = new HashMap<>();
        nodeMap.put(S_init, cur);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            if (operation == 1) {
                String S_value = st.nextToken();
                insertBeforeCur(S_value);
            } else if (operation == 2) {
                String S_value = st.nextToken();
                insertAfterCur(S_value);
            } else if (operation == 3) {
                movePrev();
            } else if (operation == 4) {
                moveNext();
            }
            printNodeValues();
        }
    }

    public static void insertBeforeCur(String value) {
        Node newNode = new Node(value);
        newNode.next = cur;
        newNode.prev = cur.prev;

        if (cur.prev != null) {
            cur.prev.next = newNode;
        }
        cur.prev = newNode;
        nodeMap.put(value, newNode);
    }

    public static void insertAfterCur(String value) {
        Node newNode = new Node(value);
        newNode.next = cur.next;
        newNode.prev = cur;

        if (cur.next != null) {
            cur.next.prev = newNode;
        }
        cur.next = newNode;
        nodeMap.put(value, newNode);
    }

    public static void movePrev() {
        if (cur.prev != null) {
            cur = cur.prev;
        }
    }

    public static void moveNext() {
        if (cur.next != null) {
            cur = cur.next;
        }
    }

    public static void printNodeValues() {
        String prevValue = (cur.prev != null) ? cur.prev.value : "(Null)";
        String curValue = cur.value;
        String nextValue = (cur.next != null) ? cur.next.value : "(Null)";

        System.out.println(prevValue + " " + curValue + " " + nextValue);
    }
}
