package com.zc;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {

    public void reorderList(ListNode head) {
        // 获取长度
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        if (size == 1 || size == 2) {
            return;
        }

        // 找出中点
        int mid = 0;
        if (size % 2 == 0) {
            mid = size / 2;
        } else {
            mid = size / 2 + 1;
        }
        tmp = head;
        for (int i = 1; i < mid; i++) {
            tmp = tmp.next;
        }
        ListNode a = tmp;
        // tmp指向了mid的下一个节点
        tmp = tmp.next;
        // mid节点指向null
        a.next = null;

        // 反转mid之后的链表
        ListNode pre = null;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        ListNode head1 = head;
        ListNode head2 = pre;
        // 从两个链表头分别遍历，反转后的链表节点插入到前面的链表中
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        new ReorderList().reorderList(l1);
        print(l1);
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
