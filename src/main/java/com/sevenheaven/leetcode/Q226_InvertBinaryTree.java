package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.TreeNode;

/**
 * Created by 7heaven on 16/5/9.
 */
public class Q226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root != null) invertNode(root);

        return root;
    }

    //递归翻转
    private void invertNode(TreeNode node){
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if(node.left != null) invertNode(node.left);
        if(node.right != null) invertNode(node.right);
    }
}
