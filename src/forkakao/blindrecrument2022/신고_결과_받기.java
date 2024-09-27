package forkakao.blindrecrument2022;

import java.util.*;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] repost = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = solution.solution(id_list, repost, k);
        Arrays.stream(answer).forEach(System.out::println);
    }
}

class Solution {

    private Map<String, Set<String>> countMap = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> users = Arrays.asList(id_list);
        // map만들기
        for(String user : users) {
            Set<String> set = new HashSet<>();
            countMap.put(user, set);
        }

        // 신고내용 적립하기, set으로 인해 중복 처리
        for (String r : report) {
            String[] s = r.split(" ");
            String from = s[0];
            String to = s[1];
            countMap.get(to).add(from);
        }

        //map 순회하면서 메일을 받는 사용자 answer에 기록
        for (Map.Entry<String, Set<String>> entry : countMap.entrySet()) {
            Set<String> set = entry.getValue();
            int getReported = set.size();
            if (getReported >= k) {
                for (String reporter : set) {
                    int idx = users.indexOf(reporter);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}