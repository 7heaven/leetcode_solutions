package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class Q19_RemoveNthNodeFromEndOfList {

    public static com.sevenheaven.leetcode.associate.ListNode removeNthFromEnd(com.sevenheaven.leetcode.associate.ListNode head, int n) {
        com.sevenheaven.leetcode.associate.ListNode recordedRemoveNode = head;
        com.sevenheaven.leetcode.associate.ListNode next = head;
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
