package leetcode.frequency;

public class ClearDigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearDigits("abc"));
        System.out.println(solution.clearDigits("cb34"));
    }

    static class Solution {
        public String clearDigits(String s) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('0' <= c && c <= '9') {
                    answer.replace(answer.length() - 1, answer.length(), "");
                    continue;
                }
                answer.append(c);
            }

            return answer.toString();
        }
    }
}
