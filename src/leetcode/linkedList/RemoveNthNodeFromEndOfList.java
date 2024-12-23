package leetcode.linkedList;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = 0;
            ListNode temp = head;
            while(temp != null) {
                length++;
                temp = temp.next;
            }

            // 삭제할 노드가 첫번째 노드
            if (length == n) {
                return head.next;
            }

            temp = head;
            for (int i = 1; i <length - n; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            return head;
        }
    }

    static public class ListNode {
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
