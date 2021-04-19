package com.zc.floyd;

import com.zc.ListNode;

/**
 * @author lizhecao 2021/3/17
 * @version 1.0
 */
public class LinkedListCycle141 {

  public boolean hasCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (null != fast || null != fast.next) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
