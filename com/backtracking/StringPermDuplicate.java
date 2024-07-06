package com.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 *Find all combination of characters of a string.
 * Tho consecutive characters of any string should not be same.
 */
public class StringPermDuplicate {
    private static int strLength=0;
    private static Set<String> tracker=null;
    public static void main(String[] args) {
       String input="abcc";
        strLength=input.length();
        tracker=new HashSet<>();
        permute(input,"");
    }


    private static void permute(String input, String rem){
        if(rem.length()==strLength && !tracker.contains(rem)) {
            System.out.println(rem);
            tracker.add(rem);
            return;
        }

        for(int i=0;i<input.length();i++)
        {
            if(rem.length()>0 &&  rem.charAt(rem.length()-1)==input.charAt(i))
                continue;
            permute(input.substring(0,i)+input.substring(i+1),rem+input.charAt(i));

        }

    }
}
