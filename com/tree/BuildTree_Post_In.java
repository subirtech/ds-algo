package com.tree;
/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */

public class BuildTree_Post_In {
    private static int post_idx=0;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        post_idx=postorder.length-1;;
        return buildTree( inorder, postorder,  0, post_idx);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end)
    {
        if(start>end)
            return null;

        int val=postorder[post_idx--];
        TreeNode node=new TreeNode(val);
        if(start==end)
            return node;
        int index=search(inorder,val,start,end);
        node.right=buildTree(inorder, postorder,index+1,end);
        node.left=buildTree(inorder, postorder,start,index-1);
        return node;
    }

    private static int search(int[] inorder,int val,int start, int end){
        for(int i=start;i<=end;i++)
        {
            if(inorder[i]==val)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(inOrder, postorder);
        InOrder.traverse(root);
    }
}
