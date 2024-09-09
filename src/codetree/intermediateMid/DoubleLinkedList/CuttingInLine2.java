package codetree.intermediateMid.DoubleLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person {
    String name;
    Person next;
    Person prev;

    public Person(String name, Person next, Person prev) {
        this.name = name;
        this.next = next;
        this.prev = prev;
    }
}

public class CuttingInLine2 {

    private static int n, m, q;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        q = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            String name = tokenizer.nextToken();
        }
    }
}
