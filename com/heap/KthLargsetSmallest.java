package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Complexity O(nLogk)
 */
public class KthLargsetSmallest {

    public static int KthLargestSmallest(int[] inputs,int k){
        //By default priorityQues is Min Heap. For Max heap use reverseOrder Comparator
        //PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int count=0;
        for(;count<k;count++)
            heap.add(inputs[count]);

        while(count< inputs.length)
        {
            //For Kth smallest < should bne changes to >
            if(heap.peek()<inputs[count]){
                heap.poll();
                heap.add(inputs[count]);
            }
            count++;
        }
        return heap.peek();

    }

    public static void main(String[] args) {
        int[] inputs=new int[]{20,10,60,30,50,40};
    System.out.println("Kth largest Element:=>"+KthLargestSmallest(inputs,3));
    }
}
