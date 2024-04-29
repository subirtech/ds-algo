package com.heap;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums
 */

class Pair {
    int num1;
    int num2;
    int sum;

    Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = num1 + num2;

    }

    public int getNum1() {
        return num1;
    }


    public int getNum2() {
        return num2;
    }

    public int getSum() {
        return sum;
    }
}

class Pair1 {
    int num1;
    int num2;
    int sum;

    Pair1(int num1, int num2, int sum) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = sum;

    }

    public int getNum1() {
        return num1;
    }


    public int getNum2() {
        return num2;
    }

    public int getSum() {
        return sum;
    }
}

public class KpairSmallestSum {
    public static List<List<Integer>> kPairSum(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> storage = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o2.getSum(), o1.getSum());
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Pair p1 = new Pair(nums1[i], nums2[j]);
                if (storage.size() < k)
                    storage.add(p1);
                else {
                    if (storage.peek().getSum() > p1.getSum()) {
                        storage.remove();
                        storage.add(p1);
                    }
                }
            }
        }
        while (storage.size() > 0) {
            Pair p1 = storage.poll();
            List<Integer> temp=new ArrayList<>();
            temp.add(p1.getNum1());
            temp.add(p1.getNum2());
            result.add(temp);
        }

        return result;
    }


    public static List<List<Integer>> optinalKPairSum(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair1> storage = new PriorityQueue<>(k, new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                return Integer.compare(o1.getSum(), o2.getSum());
            }
        });


        Set<String> visited=new HashSet<>();
        storage.add(new Pair1(0, 0, nums1[0]+nums2[0]));

        while(k-->0 && !(storage.isEmpty())){
            Pair1 p= storage.poll();
            int index1=p.getNum1();
            int index2=p.getNum2();

            List<Integer> temp=new ArrayList<>();
            temp.add(nums1[index1]);;
            temp.add(nums2[index2]);
            result.add(temp);

            if(index1+1<nums1.length && !visited.contains((index1+1)+"-"+index2)){
                storage.add(new Pair1(index1+1, index2, nums1[index1+1]+nums2[index2]));
                visited.add((index1+1)+"-"+index2);
            }

            if(index2+1<nums2.length && !visited.contains(index1+"-"+(index2+1))){
                storage.add(new Pair1(index1, index2+1, nums1[index1]+nums2[index2+1]));
                visited.add(index1+"-"+(index2+1));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,5,6};
        int[] nums2 = new int[]{3,5,7,9};
        int k = 20;
        List<List<Integer>> result = kPairSum(nums1, nums2, k);
        System.out.println(result);

        List<List<Integer>> optimalResult = optinalKPairSum(nums1, nums2, k);
        System.out.println(optimalResult);
    }

}
