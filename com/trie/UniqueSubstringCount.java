package com.trie;

/**
 * Given a string of length n of lowercase alphabet characters, we need to count total number
 * of distinct substring of this string
 * <p>
 * <p>
 * Generate all suffixes of a string
 * all prefix of all suffix will give the count
 */
public class UniqueSubstringCount {


    private static int countSubstring(Trie.Node root) {
        if (root == null)
            return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count = count + countSubstring(root.children[i]);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String input = "apple";
        for (int i = 0; i < input.length(); i++)
            Trie.insertTrie(input.substring(i));
        Trie.Node root = Trie.root;
        System.out.println("Count==>" + countSubstring(root));


    }
}
