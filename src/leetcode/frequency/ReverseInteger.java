package leetcode.frequency;

public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    static class Solution {
        public int reverse(int x) {
            StringBuilder num = new StringBuilder();
            String op = x < 0 ? "-" : "";

            long absX = Math.abs((long) x);
            for (int i = 0; i < String.valueOf(absX).length(); i++) {
                num.append(String.valueOf(absX).charAt(i));
            }
            num.reverse();
            String finalNumber = op + num;
            if (Integer.MIN_VALUE > Long.parseLong(finalNumber) || Long.parseLong(finalNumber) > Integer.MAX_VALUE) {
                return 0;
            }
            return Integer.parseInt(finalNumber);
        }
    }
}
