package leetcode.binary;

public class ReverseBits {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseBits(00000010100101000001111010011100));
    }

    static class Solution {
        public int reverseBits(int n) {
            // String으로 변경 후 풀이
//            String binaryString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
//
//            String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();
//
//            return (int) Long.parseLong(reversedBinaryString, 2);
            // 비트 연산 풀이
            int result = 0;

            for (int i = 0; i <= 31; i++) {
                result = result << 1 | (n & 1);

                n >>= 1;
            }

            return result;
        }
    }
}
