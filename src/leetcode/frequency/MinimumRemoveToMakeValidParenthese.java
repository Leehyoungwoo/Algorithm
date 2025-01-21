package leetcode.frequency;

public class MinimumRemoveToMakeValidParenthese {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("())()((("));
    }

    static class Solution {
        public String minRemoveToMakeValid(String s) {
            int plusCnt = 0;
            int minusCnt = 0;
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '(' && c != ')') {
                    answer.append(c);
                }
                if (c == '(') {
                    plusCnt++;
                    answer.append(c);
                }
                if (c == ')') {
                    if (plusCnt <= minusCnt) {
                        continue;
                    }
                    minusCnt++;
                    answer.append(c);
                }
            }
            if (plusCnt > minusCnt) {
                int diff = plusCnt - minusCnt;
                int count = 0;
                for (int i = answer.length() - 1; i >= 0; i--) {
                    char c = answer.charAt(i);
                    if (c == '(') {
                        count++;
                        answer.deleteCharAt(i);
                    }
                    if (count == diff) {
                        break;
                    }
                }
            }

            return answer.toString();
        }
    }
}
