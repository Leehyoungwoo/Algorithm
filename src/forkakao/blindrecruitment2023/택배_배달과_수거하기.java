package forkakao.blindrecruitment2023;

import java.util.Stack;

public class 택배_배달과_수거하기 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        long answer = solution.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println(answer); // 16
    }
}

class Solution2 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            deliveryStack.push(deliveries[i]);
            pickupStack.push(pickups[i]);
        }

        long move = 0;

        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int roundCap = cap;
            int currentDistance = 0;

            int furthestDelivery = -1;
            while (!deliveryStack.isEmpty() && roundCap > 0) {
                int curDelivery = deliveryStack.pop();
                if (curDelivery > 0) {
                    furthestDelivery = Math.max(furthestDelivery, deliveryStack.size() + 1);
                    if (curDelivery <= roundCap) {
                        roundCap -= curDelivery;
                    } else {
                        deliveryStack.push(curDelivery - roundCap);
                        roundCap = 0;
                    }
                }
            }

            roundCap = cap;
            int furthestPickup = -1;
            while (!pickupStack.isEmpty() && roundCap > 0) {
                int curPickup = pickupStack.pop();
                if (curPickup > 0) {
                    furthestPickup = Math.max(furthestPickup, pickupStack.size() + 1);
                    if (curPickup <= roundCap) {
                        roundCap -= curPickup;
                    } else {
                        pickupStack.push(curPickup - roundCap);
                        roundCap = 0;
                    }
                }
            }

            int furthestHouse = Math.max(furthestDelivery, furthestPickup);
            if (furthestHouse > 0) {
                move += furthestHouse * 2;
            }
        }

        return move;
    }
}
