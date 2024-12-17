package leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int start = 0;
            int end = height.length - 1;
            int maxArea = 0;

            while (start < end) {
                maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }

            return maxArea;
        }
    }
}
