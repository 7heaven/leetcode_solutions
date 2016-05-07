package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class SwapNodesInPairs_24 {
    public static ListNode swapPairs(ListNode head) {
        boolean swap = true;
        ListNode walk = head;
        ListNode latest = null;
        while(walk != null){
            if(swap){
                ListNode tmp;
                if(walk.next != null){
                    tmp = walk.next;
                    if(walk == head) head = tmp;
                    walk.next = tmp.next;
                    tmp.next = walk;
                    walk = tmp;
                    if(latest != null) latest.next = walk;
                }
            }else{
                latest = walk;
            }


            swap = !swap;
            walk = walk.next;
        }

        return head;
    }
}
