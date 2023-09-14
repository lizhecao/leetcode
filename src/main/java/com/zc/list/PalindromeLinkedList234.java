package com.zc.list;

import com.zc.ListNode;

/**
 * @author lizhecao 2021/3/23
 * @version 1.0
 */
public class PalindromeLinkedList234 {
  private ListNode cur;
  public boolean isPalindrome(ListNode head) {
    cur = head;
    return recursion(head);
  }

  public boolean recursion(ListNode head) {
    if (null == head) {
      return true;
    }

    while (recursion(head.next)) {
      if(head.val != cur.val) {
        return false;
      } else {
        cur = cur.next;
        return true;
      }
    }
    return false;
  }

}
