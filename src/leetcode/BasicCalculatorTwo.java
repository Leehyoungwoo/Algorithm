package leetcode;

import java.util.Stack;

public class BasicCalculatorTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate(" 3/2 "));
    }

    static class Solution {

        private Stack<Integer> stack = new Stack<>();

        public int calculate(String s) {
            String newS = s.replaceAll(" ", "");
            char[] ch = newS.toCharArray();
            int num = 0;
            char prevOp = '+';

            for (int i = 0; i < ch.length; i++) {
                if (Character.isDigit(ch[i])) {
                    num = num * 10 + ch[i] - '0';
                }

                // 마지막에는 숫자여도 연산을 수행해야하기 때문에
                if (!Character.isDigit(ch[i]) || i == ch.length - 1) {
                    if (prevOp == '+') {
                        stack.push(num);
                    } else if (prevOp == '-') {
                        stack.push(-num);
                    } else if (prevOp == '*') {
                        stack.push(stack.pop() * num);
                    } else if (prevOp == '/') {
                        stack.push(stack.pop() / num);
                    }

                    prevOp = ch[i];
                    num = 0;
                }
            }

            return stack.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
