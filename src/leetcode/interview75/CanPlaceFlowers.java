package leetcode.interview75;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0;
            while (i < flowerbed.length && n > 0) {
                if (flowerbed[i] == 0) {
                    boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                    boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                    if (emptyLeft && emptyRight) {
                        flowerbed[i] = 1;
                        n--;
                        i += 2;
                        continue;
                    }
                }
                i++;
            }
            return n == 0;
        }
    }
}
