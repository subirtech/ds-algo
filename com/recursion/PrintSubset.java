package com.recursion;

import java.util.ArrayList;

/**
 * Print all the subsets of set of first n natural number
 */
public class PrintSubset {

    public static void print(ArrayList<Integer> subset){
        for(int i=0;i<subset.size();i++)
        System.out.print(subset.get(i)+" ");

        System.out.println();
    }

    public static void generate(int n, ArrayList<Integer> subset){

        if(n==0)
        {
            print(subset);
            return;
        }

        // n included in subset
        subset.add(n);
        generate(n-1,subset);

        // n not included in subset
        subset.remove(subset.size()-1);
        generate(n-1,subset);

    }
    public static void main(String[] args) {
     generate(3, new ArrayList<Integer>());
    }

}
