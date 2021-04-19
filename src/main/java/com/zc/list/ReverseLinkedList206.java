package com.zc.list;

import com.zc.ListNode;

/**
 * @author lizhecao 2021/3/25
 * @version 1.0
 */
public class ReverseLinkedList206 {
  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  /**
   * 递归
   * @param head
   * @return
   */
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
