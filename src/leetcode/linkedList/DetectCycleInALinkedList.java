package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInALinkedList {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> visited = new HashSet<>();
            while(head != null) {
                if (visited.contains(head)) {
                    return true;
                }
                visited.add(head);
                head = head.next;
            }
            return false;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
