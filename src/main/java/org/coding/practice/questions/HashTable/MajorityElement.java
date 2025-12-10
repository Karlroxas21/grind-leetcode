package org.coding.practice.questions.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorityBasis = nums.length / 2;
        Map<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            res.put(nums[i], res.getOrDefault(nums[i], 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() > majorityBasis) {
                return entry.getKey();
            }
        }
        return 0;

    }
}
