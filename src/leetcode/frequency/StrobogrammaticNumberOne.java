package leetcode.frequency;

import java.util.Stack;

public class StrobogrammaticNumberOne {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isStrobogrammatic(String num) {
            if (num.contains("2") || num.contains("3") || num.contains("4") || num.contains("5") || num.contains("7")) {
                return false;
            }
            String newNumber = changeToRobe(num);
            if (num.equals(newNumber)) {
                return true;
            }

            return false;
        }

        private String changeToRobe(String num) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch == '0' || ch == '1' || ch == '8') {
                    stack.push(ch);
                    continue;
                }

                if (ch == '6') {
                    stack.push('9');
                    continue;
                }

                if (ch == '9') {
                    stack.push('6');
                }
            }
            String newNumber = "";
            while (!stack.isEmpty()) {
                newNumber += stack.pop();
            }
            return newNumber;
        }
    }
}
