package leetcode.heap;

import leetcode.linkedList.RemoveNthNodeFromEndOfList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    static class Solution {
        public RemoveNthNodeFromEndOfList.ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
            for (ListNode node : lists) {
                if (node != null) {
                    pq.add(node);
                }
            }
            ListNode head = new ListNode();
            ListNode cur = head;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                cur.next = node;
                cur = cur.next;
                if (node.next != null) {
                    pq.add(node.next);
                }
            }

            return head.next;
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
