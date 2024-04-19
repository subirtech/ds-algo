package com.tree;

public class InOrder {
    public static void traverse(TreeNode node){
        if(node==null)
            return;
        traverse(node.left);
        System.out.print(node.val+"  ");
        traverse(node.right);

    }
}
