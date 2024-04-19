package com.tree;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class BuildTree_Pre_In {
    private static int preorder_idx = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

        if (start > end)
            return null;

        int val = preorder[preorder_idx++];
        TreeNode node = new TreeNode(val);

        if (start == end)
            return node;


        int inorder_idx = search(inorder, val, start, end);
        node.left = buildTree(preorder, inorder, start, inorder_idx - 1);
        node.right = buildTree(preorder, inorder, inorder_idx + 1, end);

        return node;
    }

    private static int search(int[] inorder, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        InOrder.traverse(root);
    }

}