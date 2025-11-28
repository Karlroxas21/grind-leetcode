package org.coding.practice.questions.BinaryTree;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [1,2,4,5,6,7,3,8,9]
 * <p>
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Input: root = [1]
 * <p>
 * Output: [1]
 */
public class PreOrderTraversal {
    /**
     * Pre-order Traversal is done by visiting the root node first, then recursively do a pre-order traversal of the left subtree, followed by a recursive pre-order traversal of the right subtree. It's used for creating a copy of the tree, prefix notation of an expression tree, etc.
     *
     * This traversal is "pre" order because the node is visited "before" the recursive pre-order traversal of the left and right subtrees.
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            helper(root.left, ans);
            helper(root.right, ans);
        }
    }
}
