package leetcode.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode head = null;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                while (cur != null) {
                    list.add(cur.val);
                    cur = cur.next;
                }
            }
            Collections.sort(list);
            head = new ListNode(list.get(0));
            ListNode cur = head;
            for (int i = 1; i < list.size(); i++) {
                cur.next = new ListNode(list.get(i));
                cur = cur.next;
            }

            if (list.isEmpty()) {
                return null;
            }

            return head;
        }
    }

    static class ListNode {
        int val;
        RemoveNthNodeFromEndOfList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, RemoveNthNodeFromEndOfList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
