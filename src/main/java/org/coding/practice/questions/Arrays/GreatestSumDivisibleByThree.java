package org.coding.practice.questions.Arrays;

/**
 * 1262. Greatest Sum Divisible by Three
 *
 * Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
 *
 *
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 *
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 *
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 *
 */
public class GreatestSumDivisibleByThree {
    // We use Dynamic Programming here.
    public int maxSumDivThree(int[] nums) {
        // dp[i] stores the maximum sum seen so far that has a remainder of 'i' when divided by 3.
        // dp[0]: max sum with remainder 0 (divisible by 3)
        // dp[1]: max sum with remainder 1
        // dp[2]: max sum with remainder 2
        int[] dp = new int[3];

        for (int num : nums) {
            // This prevents using the result of the current update for subsequent remainders in the same iteration.
            int[] tempDp = new int[3];
            tempDp[0] = dp[0];
            tempDp[1] = dp[1];
            tempDp[2] = dp[2];

            // for each possible prev maximum sum (stored in tempDp)
            // calculate the new sum by adding the current num.
            for (int i = 0; i < 3; i++) {
                // only consider prev sums that are >0.
                // dp[0] being 0 is the starting state, so we handle it as a special case.
                if (tempDp[i] > 0 || (i == 0 && tempDp[0] == 0)) {
                    int newSum = tempDp[i] + num;
                    int remainder = newSum % 3;

                    // The new maximum sum for the 'remainder' state is the max of:
                    // 1. The current maximum sum for that remainder state (dp[remainder])
                    // 2. The new sum calculated (newSum)
                    dp[remainder] = Math.max(dp[remainder], newSum);
                }
            }
        }
        // The answer is the maximum sum with a remainder of 0.
        return dp[0];
    }
}
