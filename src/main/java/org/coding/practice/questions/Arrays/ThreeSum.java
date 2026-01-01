package org.coding.practice.questions.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    15. 3Sum

    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int right = nums.length;

        for (int i = 0; i < right - 2; i++) {
            // Early Exit, If the smallest element is positive, the sum can't be zero.
            if (nums[i] > 0) {
                break;
            }
            // Continue to next iteration. So we don't process the same anchor value multiple
            // times, preventing duplicate triplets in the result.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = right - 1;

            while (L < R) {
                int currentSum = nums[i] + nums[L] + nums[R];

                //found triplet
                if (currentSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    // handle inner duplicates
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }

                    // handle inner duplicates
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }

                    // move to next distinct pair
                    L++;
                    R--;
                } else if (currentSum < 0) { // sum is too small. increment L++;
                    L++;
                } else { // // sum is too large. decrement R--;
                    R--;
                }
            }
        }
        return result;
    }
}
