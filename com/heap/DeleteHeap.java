package com.heap;

import java.util.ArrayList;
import java.util.List;

public class DeleteHeap {

    public static void delete(List<Integer> nums) {
        int element = nums.get(0);
        nums.set(0, nums.remove(nums.size() - 1));

        int i = 1;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        while (i < nums.size()) {
            largest = i;
            left = largest * 2;
            right = largest * 2 + 1;
            if (left <= nums.size() && nums.get(largest - 1) < nums.get(left - 1)) {
                largest = left;
            }
            if (right <= nums.size() && nums.get(largest - 1) < nums.get(right - 1)) {
                largest = right;
            }
            if (largest != i) {
                int temp = nums.get(largest - 1);
                nums.set(largest - 1, nums.get(i - 1));
                nums.set(i - 1, temp);
                i=largest;
            }
            else
                return;
        }


    }

    public static void main(String[] args) {
        // int nums[] = new int[]{10, 30, 50, 20, 35, 15, 60};
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(30);
        nums.add(50);
        nums.add(20);
        nums.add(35);
        nums.add(15);
        nums.add(60);
        for (int i = nums.size() / 2; i > 0; i--) {
            Heapify.heapify(nums, nums.size(), i);
        }

        for (int i = 0; i < nums.size(); i++)
            System.out.print(" " + nums.get(i));

        delete(nums);
        System.out.println();
        for (int i = 0; i < nums.size(); i++)
            System.out.print(" " + nums.get(i));
    }
}
