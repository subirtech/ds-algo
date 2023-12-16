package com.recursion;

/**
 * Complexity O(n)
 */
public class MoveAllX {

    public static void moveAllX(String str, int idx, int count, String newStr) {

        if (idx == str.length()) {
            for (int i = 0; i < count; i++)
                newStr += 'x';

            System.out.println("New String:=>" + newStr);
            return;
        }

        char c = str.charAt(idx);
        if (c == 'x') {
            moveAllX(str, idx + 1, count + 1, newStr);
        } else {
            newStr += c;
            moveAllX(str, idx + 1, count, newStr);
        }


    }

    public static void main(String[] args) {
        moveAllX("xabxcdxsdxxa", 0, 0,"");
    }
}
