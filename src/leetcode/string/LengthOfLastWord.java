package leetcode.string;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord( "   fly me   to   the moon  "));
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            String[] words = s.trim().split("\\s+");
            return words[words.length - 1].length();
        }
    }
}
