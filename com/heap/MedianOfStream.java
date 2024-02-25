package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median of streams of number.
 * Create one maxHeap and MinHeap.
 * maxHeap.size()==minHeap.size()+1
 * Complexity: O(nlogn)
 */
public class MedianOfStream {

    public static double calculateMedian(int[] stream) {
        double median = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int count = 0; count < stream.length; count++) {
            if (maxHeap.size() == 0 || maxHeap.peek() > stream[count])
                maxHeap.add(stream[count]);
            else
                minHeap.add(stream[count]);


            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());
        }

        if (maxHeap.size() == minHeap.size())
            median = (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);
        else median = maxHeap.peek();

        return median;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 9, 6, 5, 8, 11, 10};

        System.out.println("Median:=>" + calculateMedian(nums));

    }
}
