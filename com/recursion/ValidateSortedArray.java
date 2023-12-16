package com.recursion;

/**
 * Complexity O(n)
 */
public class ValidateSortedArray {
    public static boolean isSorted(int[] input, int idx)
    {
      if(idx==input.length-1)
          return true;
      if(input[idx]>input[idx+1])
          return false;

      return isSorted(input,++idx);
    }

    public static void main(String[] args) {
    int[] input=new int[]{1,2,3,6,5,6,7,8,9};
    System.out.println(isSorted(input,0));
    }
}
