package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both trees are null
        if (p == null && q == null) {
            return true;
        }

        // Two List Placeholder
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        helper(p, x);
        helper(q, y);

        // Compare x and y if the same.
        return x.equals(y);
    }

    // Traverse to each Node and add them to List
    public void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            helper(node.left, res);
            helper(node.right, res);
        }
        res.add(null);
    }
}
