package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class RemoveNthNodeFromEndOfList_19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

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
