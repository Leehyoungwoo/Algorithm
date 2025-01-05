package leetcode.frequency;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(l1, l2));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode cur = null;
            StringBuilder one = new StringBuilder();
            StringBuilder two = new StringBuilder();

            while (l1 != null || l2 != null) {
                if (l1 != null) {
                    one.append(l1.val);
                    l1 = l1.next;
                }
                if (l2 != null) {
                    two.append(l2.val);
                    l2 = l2.next;
                }
            }

            StringBuilder newOne = new StringBuilder();

            int up = 0;
            int idx = 0;
            while (idx < one.length() || idx < two.length()) {
                int a = 0;
                int b = 0;
                if (idx < one.length()) {
                    a = one.charAt(idx) - '0';
                }
                if (idx < two.length()) {
                    b = two.charAt(idx) - '0';
                }
                int target = a + b;
                if (up == 1) {
                    target ++;
                    up = 0;
                }
                if (target >= 10) {
                    target -= 10;
                    up = 1;
                }
                newOne.append(target);
                idx++;
            }
            if (up == 1) {
                newOne.append(1);
            }

            newOne = newOne.reverse();
            for (int i = newOne.length() - 1; i >= 0; i--) {
                ListNode newNode = new ListNode(newOne.charAt(i) - '0');
                if (head == null) {
                    head = newNode;
                    cur = head;
                } else {
                    cur.next = newNode;
                    cur = cur.next;
                }
            }

            return head;
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
