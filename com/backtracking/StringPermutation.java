package com.backtracking;

/**
 * Permutation of String characters
 * Complexity=O(n*n!)
 */
public class StringPermutation {

    public static void permute(String str, String permStr)
    {
       if(str.length()==0)
       {
           System.out.println(permStr);
           return;
       }

        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permute(newStr,permStr+c);
        }

    }

    public static void main(String[] args) {

        permute("ABC","");
    }
}
