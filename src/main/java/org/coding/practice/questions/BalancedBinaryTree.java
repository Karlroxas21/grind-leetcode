package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Input: root = []
 * Output: true
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftNode = helper(node.left);
        if (leftNode == -1) {
            return -1;
        }

        int rightNode = helper(node.right);
        if (rightNode == -1) {
            return -1;
        }

        if (Math.abs(leftNode - rightNode) > 1) {
            return -1;
        }

        int height = 1 + Math.max(leftNode, rightNode);

        return height;

    }
}
