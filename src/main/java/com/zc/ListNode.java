package com.zc;

/**
 * @author lizhecao 2021/3/23
 * @version 1.0
 */
public class ListNode {
  public int val;
  public ListNode next;

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
