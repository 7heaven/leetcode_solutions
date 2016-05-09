package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class Q21_MergeTwoSortedLists {

    public static com.sevenheaven.leetcode.associate.ListNode mergeTwoLists(com.sevenheaven.leetcode.associate.ListNode l1, com.sevenheaven.leetcode.associate.ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        com.sevenheaven.leetcode.associate.ListNode head = l1.val > l2.val ? l2 : l1;
        com.sevenheaven.leetcode.associate.ListNode next = head;
        com.sevenheaven.leetcode.associate.ListNode l1i = head == l1 ? l1.next : l1;
        com.sevenheaven.leetcode.associate.ListNode l2i = head == l2 ? l2.next : l2;
        while(l1i != null && l2i != null){

            if(l1i.val > l2i.val){
                next.next = l2i;
                l2i = l2i.next;
                next = next.next;
            }else{
                next.next = l1i;
                l1i = l1i.next;
                next = next.next;
            }

        }

        if(l1i != null && next != null){
            next.next = l1i;
            next = next.next;
        }
        if(l2i != null && next != null) next.next = l2i;

        return head;
    }
}
