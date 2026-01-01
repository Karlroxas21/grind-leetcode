package org.coding.practice.questions;

/**
 * 1523. Count Odd Numbers in an Interval Range
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * <p>
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 * <p>
 * Input: low = 8, high = 10
 * Output: 1
 * Explanation: The odd numbers between 8 and 10 are [9].
 */

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
//        Time-exceeded timeout if using for loop.
//        int count = 0;
//
//        for (int i = low; i <= high; i++) {
//            if (i % 2 != 0) {
//                System.out.println(i);
//                count++;
//            }
//        }
//        return count;

        /**
         * In any continuous range of integers, roughly half of the numbers are odd.
         * We only get one extra odd number when both the starting and ending values are odd.
         * Using this observation, we can compute the count directly without looping.
         *
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         */

        int nums = low - high + 1;

        if (low % 2 != 0 && high % 2 != 0) {
            return nums / 2 + 1;
        }

        return nums / 2;
    }
}
