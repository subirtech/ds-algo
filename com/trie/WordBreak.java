package com.trie;

/**
 * Given an input string and a dictionary of words, find out if the input string can be broken
 * into a space-separated sequence of dictionary words.
 */
public class WordBreak {

    public static boolean wordBreak(String word) {
        if (word.isEmpty())
            return true;

        for (int i = 1; i <= word.length(); i++) {
            String first=word.substring(0, i);
            String second=word.substring(i);
            if (Trie.searchTrie(first) && wordBreak(second))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"i", "like", "sam", "softwareag", "mobile", "ice"};
        String wordKey = "ilikesoftwareag";

        for (String word : dictionary)
            Trie.insertTrie(word);

        System.out.println(wordBreak(wordKey));

    }
}
