package leetcode.frequency;

public class ShiftingLetterTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
    }

    static class Solution {

        private int[] record;

        public String shiftingLetters(String s, int[][] shifts) {
            record = new int[s.length() + 1];

            for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int direction = shift[2];
                if (direction == 0) {
                    record[start]--;
                    record[end + 1]++;
                } else {
                    record[start]++;
                    record[end + 1]--;
                }
            }

            for (int i = 1; i < record.length; i++) {
                record[i] += record[i - 1];
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                answer.append(change(s.charAt(i), record[i]));
            }
            return answer.toString();
        }

        private char change(char c, int m) {
            int shift = (m % 26 + 26) % 26;
            return (char)((c - 'a' + shift) % 26 + 'a');
        }
    }
}
