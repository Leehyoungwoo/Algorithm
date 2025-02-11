package leetcode.interview75;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int gcd = gcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        }

        public int gcd(int a, int b) {
            if (b == 0) return a;
            else return gcd(b, a % b);
        }
    }
}
