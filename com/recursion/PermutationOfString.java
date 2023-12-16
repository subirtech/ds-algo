package com.recursion;

/**
 * Complexity O(n!)
 * n*(n-1)*(n-2)* . . . . . 1
 *
 */

public class PermutationOfString {

    public static void permute(String str, String permuteStr)
    {
        if(str.length()==0)
        {
            System.out.println(permuteStr);
            return;
        }


        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permute(newStr,permuteStr+c);
        }

    }

    public static void main(String[] args) {
     permute("abcd", "");
    }
}
