package forkakao.techInternship2022;

import java.util.*;

public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA" };
        int[] choice = {5, 3, 2, 7, 5};
        String answer = solution.solution(survey, choice);
        System.out.println(answer);
    }
}

class Solution {

    private final List<String> mbti = List.of("RT", "CF", "JM", "AN");
    Map<Character, Integer> score = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 점수 채점하기
        for (int i = 0; i < survey.length; i++) {
            String types = survey[i];
            char first = types.charAt(0);
            char second = types.charAt(1);
            int response = choices[i];
            if (response == 4) {
                continue;
            }

            if (response < 4) {
                score.put(first, score.getOrDefault(first, 0) + Math.abs(4 - response));
                continue;
            }

            if (response > 4) {
                score.put(second, score.getOrDefault(second, 0) + Math.abs(response - 4));
            }
        }

        // mbti 구성하기
        for (String types : mbti) {
            char first = types.charAt(0);
            char second = types.charAt(1);
            if (score.getOrDefault(first, 0) == score.getOrDefault(second, 0)) {
                int comparison = Character.compare(first, second);
                if (comparison < 0) {
                    answer += first;
                } else {
                    answer += second;
                }
                continue;
            }

            if (score.getOrDefault(first, 0) > score.getOrDefault(second, 0)) {
                answer += first;
            } else {
                answer += second;
            }
        }

        return answer;
    }
}