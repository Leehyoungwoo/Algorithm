package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
    }

    static class Solution {
        public int countSubstrings(String s) {
            List<String> palindromes = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length() + 1; j++) {
                    String target = s.substring(i, j);
                    if (isValid(target)) {
                        palindromes.add(target);
                    }
                }
            }

            return palindromes.size();
        }

        private boolean isValid(String target) {
            for (int i = 0; i < target.length() / 2; i++) {
                if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
