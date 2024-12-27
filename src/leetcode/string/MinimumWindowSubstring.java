package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));  // "BANC"
    }

    static class Solution {
        public String minWindow(String s, String t) {
            // t의 문자 빈도 계산
            Map<Character, Integer> tCount = new HashMap<>();
            for (char c : t.toCharArray()) {
                tCount.put(c, tCount.getOrDefault(c, 0) + 1);
            }

            // 슬라이딩 윈도우를 위한 변수
            Map<Character, Integer> windowCount = new HashMap<>();
            int left = 0;
            int right = 0;
            int minLength = Integer.MAX_VALUE;
            int minStart = 0;  // 최소 윈도우의 시작 인덱스

            int required = tCount.size();  // t에서 필요한 서로 다른 문자 수
            int formed = 0;  // 윈도우에서 현재 형성된 요구사항을 충족하는 문자 수

            while (right < s.length()) {
                // 우측 문자 추가
                char c = s.charAt(right);
                windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

                // 해당 문자가 t에서 필요한 문자가 되면 formed 증가
                if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                    formed++;
                }

                // 요구사항이 모두 만족되면, 윈도우를 줄여서 최소 윈도우를 찾음
                while (left <= right && formed == required) {
                    c = s.charAt(left);

                    // 최소 길이 업데이트
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        minStart = left;
                    }

                    // 왼쪽 문자 제거
                    windowCount.put(c, windowCount.get(c) - 1);
                    if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                        formed--;
                    }

                    left++;
                }

                right++;
            }

            // 최소 윈도우를 찾지 못한 경우
            if (minLength == Integer.MAX_VALUE) {
                return "";
            }

            return s.substring(minStart, minStart + minLength);
        }
    }
}
