package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7heaven on 16/6/29.
 */
public class Q369_PlusOneLinkedList {
    public static ListNode plusOne(ListNode head) {
        if(head == null) return null;
        List<ListNode> lists = new ArrayList<>();
        lists.add(head);
        ListNode walk = head;
        while(walk.next != null){
            lists.add(walk.next);
            walk = walk.next;
        }

        boolean increasePrev = true;
        for(int i = lists.size() - 1; i >= 0; i--){
            if(lists.get(i).val == 9 && increasePrev){
                lists.get(i).val = 0;
                increasePrev = true;
            }else if(increasePrev){
                lists.get(i).val++;
                increasePrev = false;
            }
        }

        if(increasePrev){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }else{
            return head;
        }
    }
}
