package forkakao.winterintern2024;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class no4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int answer = solution4.solution(
                4,
                new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
        System.out.println(answer);
    }
}

class Solution4 {

    int n;

    public int solution(int coin, int[] cards) {
        int round = 1;
        n = cards.length;
        int curIdx = n / 3;
        List<Integer> possession = new ArrayList<>();
        for (int i = 0; i < curIdx; i++) {
            possession.add(cards[i]);
        }
        List<Integer> candidates = new ArrayList<>();

        while (true) {
            /* 반복문 종료 조건 */
            if (curIdx >= n) { // 카드 뭉치가 모두 소진되면 종료
                break;
            }

            /*  우선 후보군에 두 장 넣어둠 */
            candidates.add(cards[curIdx++]);
            candidates.add(cards[curIdx++]);

            /* 소유 중인 카드에서 n+1 가능하면 coin 안 쓰고 다음 라운드 진출 */
            if (canPlay(possession)) {
                round++;
                continue;
            }

            /* 소유 카드 중 1개 + 후보군 1개 로 n+1 가능하면 코인 1개 소진 */
            boolean flag = false;
            if (coin > 0) {
                for (int i = 0; i < possession.size(); i++) {
                    int target = n + 1 - possession.get(i);
                    if (candidates.contains(target)) {
                        possession.remove(possession.get(i));
                        candidates.remove((Integer) target);
                        coin--;
                        round++;
                        flag = true;
                        break;
                    }
                }
            }
            // 손의 패 1개 + 코인으로 한개로 flag true됐으면 다음 루프로 넘어가야함
            if (flag) {
                continue;
            }

            /* 후보군에서만 2장으로 n+1 만들 수 있는 경우에는 코인 2개 소진 */
            if (coin > 1) {
                if (canPlay(candidates)) {
                    coin -= 2;
                    round++;
                } else {
                    break;
                }
            } else {
                break;

            }
        }

        return round;
    }

    boolean canPlay(List<Integer> list) {
        List<Integer> delete = new ArrayList<>();
        if (list.isEmpty()) {
            return false;
        }

        for (int a : list) {
            for (int b : list) {
                if (a != b && a + b == n + 1) {
                    delete.add(a);
                    delete.add(b);
                    list.removeAll(delete);
                    return true;
                }
            }
        }
        return false;
    }
}
