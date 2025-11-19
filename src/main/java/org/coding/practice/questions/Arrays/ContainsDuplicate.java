package org.coding.practice.questions.Arrays;

import java.util.HashMap;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *

 Input: nums = [1,2,3,1]
 Output: true
 Explanation:
 The element 1 occurs at the indices 0 and 3.

 Input: nums = [1,2,3,4]
 Output: false
 Explanation:
 All elements are distinct.

 Input: nums = [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */

public class ContainsDuplicate {
    // [1,1,1,3,3,4,3,2,4,2]
    public boolean containsDuplicate(int[] nums) {
        // Brute force, but it causes time limit exceeded.
//        for (int i = 0; i < nums.length -1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;

        HashMap<Integer, Integer> res = new HashMap<>();
        for (int num : nums) {
            if (res.containsKey(num) && res.get(num) >= 1) {
                return true;
            }
            res.put(num, res.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
