package codetree.intermediateMid.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SpecialCharacters {

    private static String s;
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        fillMap();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        s = input.readLine();
    }

    private static void fillMap() {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 1);
                continue;
            }

            map.put(c, map.get(c) + 1);
        }
    }

    private static void printAnswer() {
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            if (map.get(c) == null) {
                continue;
            }
            if (map.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("None");
    }
}
