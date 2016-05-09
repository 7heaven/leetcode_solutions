package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/9.
 */
public class Q206_ReverseLinkedList {
    public static com.sevenheaven.leetcode.associate.ListNode reverseList(com.sevenheaven.leetcode.associate.ListNode head) {
        if(head != null && head.next != null){
            com.sevenheaven.leetcode.associate.ListNode walk = head;
            com.sevenheaven.leetcode.associate.ListNode reverse = null;
            com.sevenheaven.leetcode.associate.ListNode next = head.next;
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
