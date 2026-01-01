package org.coding.practice.questions.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 * <p>
 * You are given a binary array nums (0-indexed).
 * <p>
 * We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
 * <p>
 * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
 * <p>
 * Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
 * <p>
 * <p>
 * Input: nums = [0,1,1]
 * Output: [true,false,false]
 * Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
 * Only the first number is divisible by 5, so answer[0] is true.
 * <p>
 * Input: nums = [1,1,1]
 * Output: [false,false,false]
 * <p>
 * <p>
 * <p>
 * Multiplying by 2 shifts all bits left (similar to multiplying by 10 in decimal)
 * Adding the new bit b fills the rightmost position.
 * <p>
 * Example: Building 101
 * <p>
 * Start: 0
 * Read 1: 0×2+1=1 (decimal: 1)
 * Read 0: 1×2+0=2 (decimal: 10=2)
 * Read 1: 2×2+1=5 (decimal: 101=5)
 */
public class BinaryPrefixDivisibleByFive {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int remainder = 0;

        for (int num : nums) {
            // Calculate the remainder for the current prefix.
            // Shift the prev remainder left (multiply by 2), add the current number(bit),
            // and take modulo 5.
            remainder = (remainder * 2 + num) % 5;

            if (remainder == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
