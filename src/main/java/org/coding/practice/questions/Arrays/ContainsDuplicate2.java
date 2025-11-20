package org.coding.practice.questions.Arrays;

import java.util.HashMap;

/**
 * 219. Contains Duplicate II
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i
 * and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // store value as key and index as value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int currentNumber = nums[i];

           // found duplicate
           if (map.containsKey(currentNumber)) {
               // get the last value of last occurrence of the currentNumber. it will return the index
               int previousIndex = map.get(currentNumber);

               // then we got the previousIndex, we minus it with current index (i).
               int distance = i - previousIndex;

               if (distance <= k) {
                   return true;
               }
           }
           // update map, if no duplicates found.
           map.put(currentNumber, i);
        }
        return false;
    }
}
