package com.recursion;


/**
 * Time Complexity O(n)
 */
public class ReverseString {

    public static void reverse(String input,int idx){
    if(idx==input.length()-1)
        return;

        reverse(input,++idx);
        System.out.print(input.charAt(idx));
    }

    public static String reverse(String str)
    {
        if(str.isEmpty())
            return str;
        else{
            return reverse(str.substring(1))+str.charAt(0);
        }

    }


    public static void main(String[] args) {
        reverse("abcdxyz",-1);
        String reverseStr=reverse("abcdxyz");
        System.out.println("\nReverse String:="+reverseStr);
    }
}
