package leetcode.frequency;

public class RotateString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab"));
    }

    static class Solution {
        public boolean rotateString(String s, String goal) {
            int count = 0;
            while(!s.equals(goal)) {
                s = s.substring(1) + s.charAt(0);
                count ++;
                if (count == s.length()) {
                    break;
                }
            }

            return s.equals(goal);
        }
    }
}
