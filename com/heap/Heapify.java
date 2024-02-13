package com.heap;

import java.util.List;

public class Heapify {

    public static void heapify(int[] nums, int n, int i){
        if(i>n/2)
            return;
     int largest=i-1;
     int leftChild=i*2-1;
     int rightChild=i*2;

     if(leftChild<n && nums[largest]<nums[leftChild]){
         largest=leftChild;
     }
        if(rightChild<n && nums[largest]<nums[rightChild]){
            largest=rightChild;
        }
       if(largest!=(i-1))
       {
           int temp=nums[largest];
           nums[largest]=nums[i-1];
           nums[i-1]=temp;
           heapify(nums,n,largest+1);
       }

    }
    public static void heapify(List<Integer> nums, int n, int i) {
        if (i > n / 2)
            return;
        int largest = i - 1;
        int leftChild = i * 2 - 1;
        int rightChild = i * 2;

        if (leftChild < n && nums.get(largest) < nums.get(leftChild)) {
            largest = leftChild;
        }
        if (rightChild < n && nums.get(largest) < nums.get(rightChild)) {
            largest = rightChild;
        }
        if (largest != (i - 1)) {
            int temp = nums.get(largest);
            nums.set(largest, nums.get(i - 1));
            nums.set(i - 1, temp);
            heapify(nums, n, largest + 1);
        }

    }
    public static void main(String[] args) {
        int nums[]=new int[]{10,30,50,20,35,15,60};
      for(int i=nums.length/2;i>0;i--){
          heapify(nums,nums.length,i);
      }
      for(int i=0;i<nums.length;i++)
          System.out.print(" "+nums[i]);
    }
}
