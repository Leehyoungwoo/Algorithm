package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode newNode = new ListNode(head.val);
                newNode.next = newHead;
                newHead = newNode;
                head = head.next;
            }

            return newHead;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
