package com.heap;

import java.util.PriorityQueue;

/**
 * Connect N ropes and formed a single rope.
 * Cost of connecting two ropes of l1 and l2 is l1+l2
 * Complexity: O(nlogn)
 */
public class ConnectNRopes {
    public static int connect(int[] ropes) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++)
            heap.add(ropes[i]);
        int num1 = 0;
        int num2 = 0;
        int cost = 0;
        while (heap.size() > 1) {
            num1 = heap.poll();
            num2 = heap.poll();
            cost = cost + num1 + num2;
            heap.add(num1 + num2);
        }
        System.out.println("Final Rope Length: " + heap.poll());
        return cost;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 5, 4, 8, 6, 9};
        System.out.println("Cost to connect N Ropes:=>" + connect(nums));
    }
}
