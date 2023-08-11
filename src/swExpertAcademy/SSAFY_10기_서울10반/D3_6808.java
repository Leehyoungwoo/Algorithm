package swExpertAcademy.SSAFY_10기_서울10반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_6808 {

    private static ArrayList<Integer> cards_규영이 = new ArrayList<>();
    private static ArrayList<Integer> leftCard = new ArrayList<>();
    private static int[] cards_인영이 = new int[9];
    private static final int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ,15 ,16 ,17, 18};
    private static int testCase;
    private static int winning_규영;
    private static int losing_규영;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            init(br);
            findWinner(0, new boolean[9]);

            sb.append("#").append(tc).append(" ").append(winning_규영).append(" ").append(losing_규영).append("\n");
            cards_규영이.clear();
            leftCard.clear();
            winning_규영 = 0;
            losing_규영 = 0;
        }
        System.out.println(sb);
    }

    private static void findWinner(int idx, boolean[] visited) {
        if(idx == 9) {
            int sum_규영 = 0;
            int sum_인영 = 0;

            for (int i = 0; i < 9; i++) {
                if(cards_규영이.get(i) > cards_인영이[i]) {
                    sum_규영+=(cards_규영이.get(i) + cards_인영이[i]);
                    continue;
                }

                if(cards_규영이.get(i) < cards_인영이[i]) {
                    sum_인영+=(cards_규영이.get(i) + cards_인영이[i]);
                }
            }

            if(sum_규영 > sum_인영) {
                winning_규영++;
            }

            if(sum_규영 < sum_인영) {
                losing_규영++;
            }

            return;
        }

        for (int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cards_인영이[idx] = leftCard.get(i);
                findWinner(idx + 1, visited);
                visited[i] = false;
            }
        }
        return;
    }


    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 9; i++) {
            cards_규영이.add(Integer.parseInt(st.nextToken()));
        }

        for (int card : cards) {
            if(cards_규영이.contains(card)) {
                continue;
            }
            leftCard.add(card);
        }
    }
}