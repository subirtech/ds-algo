package com.recursion;

import java.util.HashSet;
import java.util.Set;
/**
 * Time Complexity=O(2Power(n))
 * n is number of character in input String
 */

public class PrintUniqueSubsequence {

    public static void printAllSubsequence(String str, int idx, String newStr,Set<String> tracker) {
        if (idx == str.length()) {
            if(tracker.contains(newStr))
                return;
            else {
                System.out.println(newStr);
                tracker.add(newStr);
                return;
            }
        }
        char currentCharacter = str.charAt(idx);
        printAllSubsequence(str, idx + 1, newStr + currentCharacter,tracker);
        printAllSubsequence(str, idx + 1, newStr,tracker);

    }

    public static void main(String[] args) {
        Set<String> tracker=new HashSet<>();
        printAllSubsequence("aabac",0,"",tracker);
    }
}
