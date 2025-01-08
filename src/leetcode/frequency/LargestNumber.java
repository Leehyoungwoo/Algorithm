package leetcode.frequency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[] {3,30,34,5,9}));
    }

    static class Solution {

        public String largestNumber(int[] nums) {
            List<String> numList = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
            numList.sort((a, b) -> {
               String order1 = a + b;
               String order2 = b + a;
               return order2.compareTo(order1);
            });
            int count = 0;
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i).equals("0")) {
                    count++;
                }
            }
            if (count == numList.size()) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numList.size(); i++) {
                res.append(numList.get(i));
            }

            return res.toString();
        }
    }
}
