package leetcode.frequency;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(3));
    }

    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    res.add("FizzBuzz");
                    continue;
                }
                if (i % 3 == 0) {
                    res.add("Fizz");
                    continue;
                }
                if (i % 5 == 0) {
                    res.add("Buzz");
                    continue;
                }
                res.add(String.valueOf(i ));
            }

            return res;
        }
    }
}
