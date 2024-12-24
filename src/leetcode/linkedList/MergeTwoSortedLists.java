//package leetcode.linkedList;
//
//
//public class MergeTwoSortedLists {
//
//    public static void main(String[] args) {
//
//    }
//
//    static class Solution {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            if (list1 == null) return list2;
//            if (list2 == null) return list1;
//
//            ListNode head = list1.val <= list2.val ? list1 : list2;
//            ListNode cur = head;
//
//            if (head == list1) {
//                list1 = list1.next;
//            } else {
//                list2 = list2.next;
//            }
//
//            while (list1 != null && list2 != null) {
//                if (list1.val <= list2.val) {
//                    cur.next = list1;
//                    list1 = list1.next;
//                } else {
//                    cur.next = list2;
//                    list2 = list2.next;
//                }
//
//                cur = cur.next;
//            }
//
//            if (list1 != null) {
//                cur.next = list1;
//            } else {
//                cur.next = list2;
//            }
//
//            return head;
//        }
//    }
//
//     static class ListNode {
//        int val;
//        RemoveNthNodeFromEndOfList.ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, RemoveNthNodeFromEndOfList.ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//}
