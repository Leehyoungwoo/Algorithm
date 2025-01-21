package leetcode.frequency;

public class StringCompressionTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressedString("aaaaaaaaaaaaaabb"));
    }

    static class Solution {
        public String compressedString(String word) {
            StringBuilder answer = new StringBuilder();
            int count = 0;
            char prev = '0';
            for (int i = 0; i < word.length(); i++) {
                if (prev == '0') {
                    prev = word.charAt(i);
                }
                char c = word.charAt(i);
                if (c == prev) {
                    count++;
                } else {
                    answer.append(count).append(prev);
                    count = 1;
                }

                if (count == 9) {
                    answer.append(count).append(prev);
                    prev = '0';
                    count = 0;
                    continue;
                }

                prev = c;
            }

            if (count != 0 && prev != '0') {
                answer.append(count).append(prev);
            }
            return answer.toString();
        }
    }
}
