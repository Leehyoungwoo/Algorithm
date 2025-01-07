package leetcode.frequency;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mergeAlternately("cf", "eee"));
    }

    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder answer = new StringBuilder();
            int idx1 = 0;
            int idx2 = 0;
            while (idx1 < word1.length() && idx2 < word2.length()) {
                answer.append(word1.charAt(idx1));
                idx1++;
                answer.append(word2.charAt(idx2));
                idx2++;
            }
            if (idx1 - 1 < word1.length() - 1) {
                answer.append(word1.substring(idx1));
            }
            else if (idx2 - 1 < word2.length() - 1) {
                answer.append(word2.substring(idx2));
            }
            return answer.toString();
        }
    }
}
