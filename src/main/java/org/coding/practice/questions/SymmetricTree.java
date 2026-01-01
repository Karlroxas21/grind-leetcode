package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

/**
 * 101. Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
//        3 and 4
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode nodeOne, TreeNode nodeTwo) {
        // if all values are called
        if(nodeOne == null && nodeTwo == null) {
            return true;
        }

        // if tree is uneven or val are not the same
        if(nodeOne == null || nodeTwo == null || nodeOne.val != nodeTwo.val) {
            return false;
        }

        // recursively call
        return helper(nodeOne.left, nodeTwo.right) && helper(nodeOne.right, nodeTwo.left);
    }
}
