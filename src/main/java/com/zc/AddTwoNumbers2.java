package com.zc;

/**
 * @author lizhecao 2021/3/21
 * @version 1.0
 */
public class AddTwoNumbers2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null, cur = null;
    int carry = 0;
    while (null != l1 || null != l2) {
      int a1 = 0, a2 = 0;
      if (null != l1) {
        a1 = l1.val;
        l1 = l1.next;
      }
      if (null != l2) {
        a2 = l2.val;
        l2 = l2.next;
      }
      int val = (a1 + a2 + carry) % 10;
      carry = (a1 + a2 + carry) / 10;
      ListNode temp = new ListNode(val);
      if (null == head) {
        head = cur = temp;
      } else {
        cur.next = temp;
        cur = cur.next;
      }

    }
    if (carry != 0) {
      cur.next = new ListNode(carry);
    }
    return head;
  }
}

