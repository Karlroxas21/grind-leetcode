package org.coding.practice.questions;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // Edge case, if 0 or 1 we return 1.
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        // start iteration in 2 because 2 steps is the max steps we can climb (can solve by prev + curr = 2)
        for (int i = 2; i <= n; i++) {
            // shift values.
            // intialize temp as holder for curr value
            int temp = curr;
            // curr value will hold sum of prev and curr
            curr = prev + curr;
            // prev value will get temp(which is curr value)
            prev = temp;
        }
        return curr;
    }
}
