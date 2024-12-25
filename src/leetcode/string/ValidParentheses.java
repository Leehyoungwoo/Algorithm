package leetcode.string;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                    if (c == ']' &&stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
