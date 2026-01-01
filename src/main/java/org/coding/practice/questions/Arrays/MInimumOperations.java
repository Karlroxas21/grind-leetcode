package org.coding.practice.questions.Arrays;

/**
 *
 * 319. Find Minimum Operations to Make All Elements Divisible by Three
 *
 * You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
 *
 * Return the minimum number of operations to make all elements of nums divisible by 3.
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation:
 * All array elements can be made divisible by 3 using 3 operations:
 *     Subtract 1 from 1.
 *     Add 1 to 2.
 *     Subtract 1 from 4.
 *
 * Input: nums = [3,6,9]
 * Output: 0
 *
 */
public class MInimumOperations {
    public int minimumOperations(int[] nums) {
        // we store result here.
        int operation = 0;

        // traverse in array
        for(int i = 0; i < nums.length; i++) {
            // we use module to get if it's divisible by 3 and how many remainder is after dividing to 3.
            // if not divisible by 3 and remainder is >= 2, we add +1 to current index and add operation.
            if (nums[i] % 3 != 0 && nums[i] % 3 >= 2) {
                nums[i] += 1;
                operation++;
            }
            // if not divisible by 3 and remainder is < 2, we add -1 to current index and add operation.
            else if (nums[i] % 3 != 0 && nums[i] % 3 < 2) {
                nums[i] -= 1;
                operation++;
            }
        }
        return operation;
    }
}
