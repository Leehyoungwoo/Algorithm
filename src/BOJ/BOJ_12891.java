package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ_12891 {

    private static Map<Character, Integer> map = new HashMap<>();
    private static int S;
    private static int P;
    private static final char[] password = {'A', 'C', 'G', 'T'};
    private static int[] policy = new int[4];
    private static String givenStr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.print(findDNACnt());
    }

    private static int findDNACnt() {
        LinkedList<Character> list = new LinkedList<>();
        mapSetting();
        int cnt = 0;

        for (int i = 0; i < givenStr.length(); i++) {
            char c = givenStr.charAt(i);
            list.addLast(c);
            map.put(c, map.get(c) + 1);

            if (list.size() > P) {
                Character remove = list.getFirst();
                list.removeFirst();
                map.put(remove, map.get(remove) - 1);
            }

            if(list.size() == P && isValidPassword()) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean isValidPassword() {
        return map.get('A') >= policy[0] && map.get('C') >= policy[1] &&
                map.get('G') >= policy[2] && map.get('T') >= policy[3];
    }

    private static void mapSetting() {
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        S = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        givenStr = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < policy.length; i++) {
            policy[i] = Integer.parseInt(st.nextToken());
        }
    }
}