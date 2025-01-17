package leetcode.frequency;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }

    static class Solution {

        private List<String> sequence;
        private boolean[] used;

        public String getPermutation(int n, int k) {
            sequence = new ArrayList<>();
            used = new boolean[n + 1];
            generatePermutation(0, n, new StringBuilder());
            return sequence.get(k - 1);
        }

        private void generatePermutation(int idx, int n, StringBuilder builder) {
            if (idx == n) {
                sequence.add(builder.toString());
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    builder.append(i);
                    generatePermutation(idx + 1, n, builder);
                    builder.deleteCharAt(builder.length() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
