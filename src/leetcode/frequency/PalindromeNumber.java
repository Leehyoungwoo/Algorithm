package leetcode.frequency;

public class PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < String.valueOf(x).length(); i++) {
                builder.append(String.valueOf(x).charAt(i));
            }
            String original = builder.toString();
            String reverse = builder.reverse().toString();
            if (Long.parseLong(original) == Long.parseLong(reverse)) {
                return true;
            }
            return false;
        }
    }
}
