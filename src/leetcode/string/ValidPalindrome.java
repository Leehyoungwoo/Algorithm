package leetcode.string;

public class ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }

            return true;
        }
    }
}
