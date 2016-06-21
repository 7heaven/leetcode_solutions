package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.ListNode;

/**
 * Created by 7heaven on 16/5/3.
 */
public class Q237_DeleteNodeInALinkedList {


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
