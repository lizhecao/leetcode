package com.zc;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode check = head;
        for (int i = 0;i < k;i ++) {
            if (check == null) {
                return head;
            }
            check = check.next;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode pre = null;
        for (int i = 0;i < k;i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//
//
//
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        print(new ReverseKGroup().reverseKGroup(l1, 3));
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
