package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Input: root = [1,null,2]
 * Output: 2
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Traverse to left and right.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // +1 because of the root itself.
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;

        return maxDepth;
    }
}
