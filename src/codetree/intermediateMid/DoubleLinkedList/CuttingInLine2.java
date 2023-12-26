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
    private static List<List<String>> lines = new ArrayList<>();
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        q = Integer.parseInt(tokenizer.nextToken());
        x = n / m;
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            String name = tokenizer.nextToken();
            people.add(new Person(name, null, null));
        }

        // 줄 초기화
        for (int i = 0; i < m; i++) {
            lines.add(new ArrayList<>());
        }

        // 사람들을 줄에 배치
        for (int i = 0; i < n; i++) {
            int lineNum = i % m;
            lines.get(lineNum).add(people.get(i).name);
        }

        // 준이의 문자 처리
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int command = Integer.parseInt(tokenizer.nextToken());
            if (command == 1) {  // 새치기
                String name_a = tokenizer.nextToken();
                String name_b = tokenizer.nextToken();
                for (List<String> line : lines) {
                    if (line.contains(name_a)) {
                        int idx_a = line.indexOf(name_a);
                        line.add(idx_a, name_b);
                    }
                }
            } else if (command == 2) {  // 집으로 감
                String name = tokenizer.nextToken();
                for (List<String> line : lines) {
                    if (line.contains(name)) {
                        line.remove(name);
                    }
                }
            } else if (command == 3) {  // 통째로 새치기
                String name_a = tokenizer.nextToken();
                String name_b = tokenizer.nextToken();
                String name_c = tokenizer.nextToken();
                for (List<String> line : lines) {
                    if (line.contains(name_a) && line.contains(name_b)) {
                        int idx_a = line.indexOf(name_a);
                        int idx_b = line.indexOf(name_b);
                        List<String> subList = line.subList(idx_a, idx_b + 1);
                        for (int j = 0; j < subList.size(); j++) {
                            subList.set(j, name_c);
                        }
                    }
                }
            }
        }

        // 결과 출력
        for (List<String> line : lines) {
            if (!line.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String name : line) {
                    sb.append(name).append(" ");
                }
                System.out.println(sb.toString().trim());
            } else {
                System.out.println(-1);
            }
        }
    }
}
