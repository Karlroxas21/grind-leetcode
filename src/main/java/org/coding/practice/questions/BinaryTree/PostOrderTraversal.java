package org.coding.practice.questions.BinaryTree;

import org.coding.practice.questions.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [4,6,7,5,2,9,8,3,1]
 * <p>
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Input: root = [1]
 * Output: [1]
 */
public class PostOrderTraversal {
    /**
     * In Postorder Traversal, the rule for visiting a room is:
     * <p>
     * Go to the Left Wing: You must finish exploring everything in the entire left side of the current room first.
     * <p>
     * Go to the Right Wing: Then, you must finish exploring everything in the entire right side of the current room.
     * <p>
     * Finally, Check In: Only after you've completely finished exploring both the left and right wings do you finally check into the current room (i.e., you "post" or "record" its value).
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            helper(root.left, ans);
            helper(root.right, ans);
            ans.add(root.val);
        }
    }
}
