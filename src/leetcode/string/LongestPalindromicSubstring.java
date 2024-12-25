package leetcode.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("bb"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            String res = "";
            int maxLen = Integer.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String target = s.substring(i, j);
                    if (isValid(target)) {
                        if (maxLen < target.length()) {
                            maxLen = target.length();
                            res = target;
                        }
                    }
                }
            }


            return res;
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
