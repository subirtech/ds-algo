package com.recursion;

/**
 * Time Complexity=O(2Power(n))
 * n is number of character in input String
 */

public class PrintAllSubsequence {

    public static void printAllSubsequence(String str, int idx, String newStr) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currentCharacter = str.charAt(idx);
        printAllSubsequence(str, idx + 1, newStr + currentCharacter);
        printAllSubsequence(str, idx + 1, newStr);

    }

    public static void main(String[] args) {
        printAllSubsequence("abc",0,"");
    }
}
