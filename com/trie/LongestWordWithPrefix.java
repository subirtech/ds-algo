package com.trie;

/**
 * Longest word with All prefixes
 */

public class LongestWordWithPrefix {
    static String longestWord = "";

    private static void longestWord(Trie.Node root, StringBuilder stbr) {
        if (root == null)
            return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                stbr.append((char) (i + 'a'));
                if (longestWord.length() < stbr.length())
                    longestWord = stbr.toString();
                longestWord(root.children[i], stbr);
                stbr.deleteCharAt(stbr.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (String word : words)
            Trie.insertTrie(word);

        longestWord(Trie.root, new StringBuilder(""));

        System.out.println("Longest Word:=>" + longestWord);

    }

}
