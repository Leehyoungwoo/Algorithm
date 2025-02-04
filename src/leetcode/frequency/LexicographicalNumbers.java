package leetcode.frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(13));
    }

    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(String.valueOf(i));
            }

            Collections.sort(list);
            List<Integer> res = new ArrayList<>();
            for (String s : list) {
                res.add(Integer.parseInt(s));
            }

            return res;
        }
    }
}
