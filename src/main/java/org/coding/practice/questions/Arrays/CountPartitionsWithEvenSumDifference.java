package org.coding.practice.questions.Arrays;

/**
 * 3432. Count Partisions with Even Sum Difference
 * <p>
 * You are given an integer array nums of length n.
 * A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
 * Left subarray contains indices [0, i].
 * Right subarray contains indices [i + 1, n - 1].
 * Return the number of partitions where the difference between the sum of the left and right subarrays is even.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,10,3,7,6]
 * <p>
 * Output: 4
 * <p>
 * Explanation:
 * <p>
 * The 4 partitions are:
 * <p>
 * [10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
 * [10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
 * [10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
 * [10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,2]
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * No partition results in an even sum difference.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [2,4,6,8]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * All partitions result in an even sum difference.
 */

public class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int left = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            int right = total - left;
            System.out.println("LEFT: " + left);
            System.out.println("RIGHT: " + right);

            if ((left % 2) == (right % 2)) {
                count++;
            }
        }

        return count;
    }
}
