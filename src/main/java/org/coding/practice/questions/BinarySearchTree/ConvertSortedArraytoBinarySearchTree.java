package org.coding.practice.questions.BinarySearchTree;

/*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a binary search tree.
    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted

    Input: nums = [1,3]
    Output: [3,1]
    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

    Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
 */

import java.util.ArrayList;

public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        int numsLength = nums.length - 1;
        int startIndex = 0;
        return createBST(nums, startIndex, numsLength);
    }

    private TreeNode createBST(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }

        // Find middle element
        int midIndex = (startIndex + endIndex) / 2;

        TreeNode currentNode = new TreeNode(nums[midIndex]);

        currentNode.left = createBST(nums, startIndex, midIndex -1);

        currentNode.right = createBST(nums, midIndex + 1, endIndex);

        return currentNode;
    }
}


