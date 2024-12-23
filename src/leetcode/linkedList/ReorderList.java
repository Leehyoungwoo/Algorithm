package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public static void main(String[] args) {

    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }

            List<ListNode> list = new ArrayList<>();
            ListNode temp = head;
            while(temp != null) {
                list.add(temp);
                temp = temp.next;
            }
            int left = 0;
            int right = list.size() - 1;
            while(left < right) {
                list.get(left).next = list.get(right);
                left++;
                if (left == right) {
                    break;
                }
                list.get(right).next = list.get(left);
                right--;
            }

            list.get(left).next = null;
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
