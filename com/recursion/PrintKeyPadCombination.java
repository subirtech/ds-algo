package com.recursion;

/**
 * 6="pqrs"==>length 4
 * 66666==> here n=5
 * Time Complexity=4power(n)
 */

public class PrintKeyPadCombination {
    private static String[] keyPad = new String[]{".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printKeyPadComb(String str, int idx, String newStr) {
        if (idx == str.length()) {
            System.out.print(newStr+"  ");
            return;
        }
        int index = str.charAt(idx) - '0';
        String keys = keyPad[index];
        for (int i = 0; i < keys.length(); i++) {
            printKeyPadComb(str, idx + 1, newStr + keys.charAt(i));
        }
    }

    public static void main(String[] args) {
        printKeyPadComb("236",0,"");
    }
}
