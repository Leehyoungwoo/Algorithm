package leetcode.string;

public class ValidAnagram {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("rat", "car"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] visited = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                visited[c - 'a']++;
            }
            int[] visited2 = new int[26];
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                visited2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (visited[i] != visited2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
