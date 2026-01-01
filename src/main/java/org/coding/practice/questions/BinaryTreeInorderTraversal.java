package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given the `root` of a binary tree, return the inorder traversal of it's nodes values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [4,2,6,5,7,1,3,9,8]
 */


public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;

    }

    /**
     * Self-explanation.
     * Inorder traversal, we're describing a very specific order in which we visit the nodes of that tree.
     * The "inorder" literally comes from the idea of visiting nodes "in order", according to their structure in the tree.
     *
     * Logic:
     * 1. Visit the left subtree
     * 2. Write down current node's value
     * 3. Visit the right subtree
     *
     * Repeat until root(current node) is null
     */
    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            helper(root.left, ans);
            ans.add(root.val);
            helper(root.right, ans);
        }
    }

    /**
     * Visualization:
     *
     * helper(1)
     * │
     * ├── helper(2)    ← go left
     * │   │
     * │   ├── helper(4)   ← go left of 2
     * │   │   ├── left = null → return
     * │   │   ├── add(4)
     * │   │   └── right = null → return
     * │   │
     * │   ├── add(2)
     * │   │
     * │   └── helper(5)   ← go right of 2
     * │       ├── helper(6)
     * │       │   ├── left = null → return
     * │       │   ├── add(6)
     * │       │   └── right = null → return
     * │       │
     * │       ├── add(5)
     * │       │
     * │       └── helper(7)
     * │           ├── left = null → return
     * │           ├── add(7)
     * │           └── right = null → return
     * │
     * ├── add(1)
     * │
     * └── helper(3)    ← go right
     *     ├── left = null → return
     *     ├── add(3)
     *     └── helper(8)
     *         ├── helper(9)
     *         │   ├── left = null → return
     *         │   ├── add(9)
     *         │   └── right = null → return
     *         │
     *         ├── add(8)
     *         └── right = null → return
     */
}
