package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class Q24_SwapNodesInPairs {
    public static com.sevenheaven.leetcode.associate.ListNode swapPairs(com.sevenheaven.leetcode.associate.ListNode head) {
        boolean swap = true;
        com.sevenheaven.leetcode.associate.ListNode walk = head;
        com.sevenheaven.leetcode.associate.ListNode latest = null;
        while(walk != null){
            if(swap){
                com.sevenheaven.leetcode.associate.ListNode tmp;
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
