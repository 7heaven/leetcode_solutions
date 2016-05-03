package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/3.
 */
public class DeleteNodeInALinkedList_237 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }


    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        if(nextNode != null){
            node.val = nextNode.val;
            node.next = nextNode.next;

            nextNode.next = null;
            nextNode = null;
        }
    }
}
