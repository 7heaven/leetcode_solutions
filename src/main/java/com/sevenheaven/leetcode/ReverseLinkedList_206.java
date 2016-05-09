package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/9.
 */
public class ReverseLinkedList_206 {
    public static ListNode reverseList(ListNode head) {
        if(head != null && head.next != null){
            ListNode walk = head;
            ListNode reverse = null;
            ListNode next = head.next;
            walk.next = null;
            while(next != null && walk != null){
                reverse = next.next;

                next.next = walk;
                walk = next;
                next = reverse;


            }

            return walk;
        }else{
            return head;
        }
    }
}
