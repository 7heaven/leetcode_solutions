package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.ListNode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class Q19_RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode recordedRemoveNode = head;
        ListNode next = head;
        int step = 0;
        while(next != null){


            if(step == n + 1){
                recordedRemoveNode = recordedRemoveNode.next;
            }else{
                step++;
            }

            next = next.next;
        }

        if(recordedRemoveNode != head || step == n + 1){
            recordedRemoveNode.next = recordedRemoveNode.next.next;
        }else{
            head = recordedRemoveNode.next;
        }

        return head;
    }
}
