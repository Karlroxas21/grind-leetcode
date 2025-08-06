package org.coding.practice.questions;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 *     For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

public class Sqrt {
    public int mySqrt(int x) {
        if(x < 0){
            return 0;
        }

        // search space
        long low = 0;
        long high = x;
        long ans = 0;

        // binary search
        while (low <= high) {
            // calculate middle of search space
            long mid = low + (high - low) / 2;

            // squared. we use long to prevent overflow.
            long mid_sqrd = mid * mid;

            if (mid_sqrd == x) {
                return (int) mid;
            }else if (mid_sqrd < x) {
                ans = mid;
                low = mid + 1;
            }else if (mid_sqrd > x) {
                high = mid - 1;
            }
        }

        return (int) ans;

    }
}
