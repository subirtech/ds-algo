package com.slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t){
        if(t.length()>s.length())
            return "";
        int window=Integer.MAX_VALUE;
        String strWindow="";
        Map<Character, Integer> origStorage=new HashMap<>();
        for(int i=0;i<t.length();i++)
            origStorage.put(t.charAt(i),origStorage.get(t.charAt(i))==null?1:origStorage.get(t.charAt(i))+1);
        int i=0,j=0;
        for(;i<s.length();i++){
            if(origStorage.containsKey(s.charAt(i)))
            {
                origStorage.put(s.charAt(i), origStorage.get(s.charAt(i))-1);
                while(j<=i && validate(origStorage)){
                    while(j<=i){
                        if(origStorage.containsKey(s.charAt(j))){
                            if(window>(i-j+1)){
                                window=(i-j+1);
                                strWindow=s.substring(j,i+1);
                            }
                            origStorage.put(s.charAt(j), origStorage.get(s.charAt(j))+1);
                            j++;
                            break;
                        }
                        j++;

                    }
                }
            }
        }
        return strWindow;


    }

    private static boolean validate( Map<Character, Integer> origStorage){
        Iterator<Character> iterator = origStorage.keySet().iterator();
        while (iterator.hasNext()) {
            if(origStorage.get(iterator.next())>0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String  s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));

    }
}
