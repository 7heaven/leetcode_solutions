package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/3.
 */
public class Q237_DeleteNodeInALinkedList {


    public static void deleteNode(com.sevenheaven.leetcode.associate.ListNode node) {
        com.sevenheaven.leetcode.associate.ListNode nextNode = node.next;
        if(nextNode != null){
            node.val = nextNode.val;
            node.next = nextNode.next;

            nextNode.next = null;
            nextNode = null;
        }
    }
}
