package leetcode.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[] {"bdddddddddd","bbbbbbbbbbc"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = "";
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                for (char c : chars) {
                    key += c;
                }
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(key, list);
                }
            }
            List<List<String>> res = new ArrayList<>();
            for(Map.Entry<String, List<String>> entry : map.entrySet()) {
                List<String> list = entry.getValue();
                res.add(list);
            }

            return res;
        }
    }
}
