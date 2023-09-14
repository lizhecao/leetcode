package com.zc.floyd;

/**
 * @author lizhecao 2021/3/17
 * @version 1.0
 */
public class LinkedListCycle142 {

  public ListNode detectCycle(ListNode head) {
    if (null == head || null == head.next) {
      return null;
    }
    ListNode fast = head.next, slow = head;
    while (fast != slow) {

      if (null == fast || null == fast.next) {
        return null;
      }

      fast = fast.next.next;
      slow = slow.next;
    }

    fast = head;
    slow = slow.next;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }

    return fast;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
