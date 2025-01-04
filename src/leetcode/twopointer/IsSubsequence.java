package leetcode.twopointer;

import java.util.Arrays;

public class IsSubsequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("b", "abc"));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }

            if (s.length() != 0 && t.length() == 0) {
                return false;
            }

            int sLen = 0;
            int tLen = 0;
            boolean[] isSub = new boolean[s.length()];
            while (tLen < t.length()) {
                if (s.charAt(sLen) == t.charAt(tLen)) {
                    isSub[sLen] = true;
                    sLen++;
                }
                if (sLen == s.length()) {
                    break;
                }
                tLen++;
            }

            for (int i = 0; i < isSub.length; i++) {
                if (!isSub[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
