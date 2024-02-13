package com.heap;

import java.util.ArrayList;
import java.util.List;

public class InsertHeap {



    public  static void insert(List<Integer> nums, int item) {
        nums.add(item);
        int itemPos = nums.size();
        int parent = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;
        while (itemPos > 1) {
            parent = itemPos / 2 - 1;
            if (nums.get(parent) < nums.get(itemPos - 1)) {
                temp = nums.get(parent);
                nums.set(parent, nums.get(itemPos - 1));
                nums.set(itemPos - 1 , temp);
                itemPos = parent + 1;
            }else
                break;
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

        insert(nums,40);
        System.out.println();
        for (int i = 0; i < nums.size(); i++)
            System.out.print(" " + nums.get(i));
    }
}
