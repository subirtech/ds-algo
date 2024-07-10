package com.trie;

/**
 * Check a particular word is prefix of any other words in the list or not.
 */
public class StartsWith {

    public static boolean startSWith(String prefix) {
        Trie.Node current = Trie.root;
        int idx = 0;
        for (int i = 0; i < prefix.length(); i++) {
            idx = prefix.charAt(i) - 'a';
            if (current.children[idx] == null)
                return false;

            if (current.children[idx] != null) {
                if (i == prefix.length() - 1)
                    return true;
                current = current.children[idx];

            }

        }
        return false;

    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dictionary = new String[]{"apple", "app", "mango", "man", "woman"};
        for (String str : dictionary)
            Trie.insertTrie(str);
        System.out.println("Prefix Exist:=>"+startSWith("mango"));


    }
}
