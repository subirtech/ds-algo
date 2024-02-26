package com.trie;

public class Trie {
    static class Node {
        Node[] children = null;
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++)
                children[i] = null;
        }
    }

    static Node root = new Node();

    public static Node insertTrie(String word) {
        Node current = root;
        char letter;
        int index;
        for (int count = 0; count < word.length(); count++) {
            letter = word.charAt(count);
            index = letter - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
                current = current.children[index];
                if (count == word.length() - 1)
                    current.eow = true;
            }else{
                current = current.children[index];
                if (count == word.length() - 1)
                    current.eow = true;
            }
        }
        return current;
    }

    public static boolean searchTrie(String word) {
        Node current = root;
        char letter;
        int index;
        for (int count = 0; count < word.length(); count++) {
            letter = word.charAt(count);
            index = letter - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
                if ((count == word.length() - 1) && (current.eow == false))
                    return false;

            } else
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
     String[] dictionary=new String[]{"apple","water","book"};
     for(String word: dictionary)
         insertTrie(word);

     System.out.println(searchTrie("apple"));
     System.out.println(searchTrie("app"));
     System.out.println(searchTrie("appla"));
     System.out.println(searchTrie("wator"));
     System.out.println(searchTrie("water"));
    }


}
