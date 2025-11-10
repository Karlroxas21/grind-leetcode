package org.coding.practice.questions;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

/**
 * 112. Path Sum
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base Case: If the current node is null (reached past a leaf or started with an empty tree)
        // if root is null:
        if (root == null) {
            return false;
        }

        //Success Case (The Path Found): If the current node is a leaf AND its value
        //equals the remaining targetSum, we found a root-to-leaf path.
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        //Recursive Step: Subtract the current nodes value from the targetSum.
        //The new target for the children is the remaining sum needed.
        int remainingTarget = targetSum - root.val;

        //Check if a path exists in the left subtree OR the right subtree.
        //We only need one path to succeed, so we use the OR operator.
        boolean leftPathFound = hasPathSum(root.left, remainingTarget);
        boolean rightPathFound = hasPathSum(root.right, remainingTarget);

        return leftPathFound || rightPathFound;
    }
}
