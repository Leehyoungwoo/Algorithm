package leetcode.frequency;

public class MaximumSwap {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(98368));
    }

    static class Solution {
        public int maximumSwap(int num) {
            String number = String.valueOf(num);
            char[] ch = number.toCharArray();
            for (int i = 0; i < ch.length - 1; i++) {
                int first = ch[i] -'0';
                int max = ch[i] - '0';
                int changeIdx = i;
                for (int j = i + 1; j < ch.length; j++) {
                    if (ch[j] - '0' >= max) {
                       max = ch[j] - '0';
                       changeIdx = j;
                    }
                }
                if (changeIdx != i && first != max) {
                    char temp = ch[i];
                    ch[i] = ch[changeIdx];
                    ch[changeIdx] = temp;
                    number = new String(ch);
                    break;
                }
            }
            return Integer.parseInt(number);
        }
    }
}
