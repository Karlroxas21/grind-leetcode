package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //
        if (left == 0 && right == 0) {
            return 1;
        }

        // Unbalanced tree. If left subtree is empty
        if (left == 0) {
            // Take the right depth and ignore the left.
            return right + 1;
        }

        if (right == 0) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
}
