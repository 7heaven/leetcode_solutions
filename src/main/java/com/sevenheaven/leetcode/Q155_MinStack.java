package com.sevenheaven.leetcode;

import java.util.Arrays;

public class Q155_MinStack {

    public static class MinStack {
    
         private static final int MIN_INCREMENT = 60;
    
         private int[] store = new int[MIN_INCREMENT];
         private int storeCursor = -1;
         private int storedMinValue = Integer.MAX_VALUE;
    
         private int[] minStore = new int[MIN_INCREMENT];
         private int[] lastCursors = new int[MIN_INCREMENT];
         private int minCursor = -1;

         /** initialize your data structure here. */
         public MinStack() {
        
         }
    
         public void push(int x) {
             if(storeCursor >= store.length - 1){
                 store = Arrays.copyOf(store, store.length + MIN_INCREMENT);
             }
             store[++storeCursor] = x;
        
             if(minCursor >= minStore.length - 1){
                 minStore = Arrays.copyOf(minStore, minStore.length + MIN_INCREMENT);
                 lastCursors = Arrays.copyOf(lastCursors, lastCursors.length + MIN_INCREMENT);
             }
        
             if(minCursor == -1 || x < minStore[minCursor]){
                 minStore[++minCursor] = x;
                 lastCursors[minCursor] = storeCursor;
             }
         }
    
         public void pop() {
             if(lastCursors[minCursor] == storeCursor) minCursor--;
             storeCursor--;
         }
    
         public int top() {
             return storeCursor == -1 ? 0 : store[storeCursor];
         }
    
         public int getMin() {
             return minStore[minCursor];
         }
    }
}
