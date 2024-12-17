package leetcode;

import java.util.Arrays;

public class NumberOfOneBits {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11));
    }

    static class Solution {
        public int hammingWeight(int n) {
//            return Integer.bitCount(n);
            return (int) Integer.toBinaryString(n)
                    .chars()
                    .filter(c -> c == '1').count();
        }
    }
}
