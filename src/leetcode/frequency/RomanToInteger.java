package leetcode.frequency;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> romanMap = new HashMap<>();
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);

            int result = 0;
            int prev = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                int curVal = romanMap.get(c);

                if (prev > curVal) {
                    result -=curVal;
                } else {
                    result += curVal;
                }

                prev = curVal;
            }

            return result;
        }
    }
}
