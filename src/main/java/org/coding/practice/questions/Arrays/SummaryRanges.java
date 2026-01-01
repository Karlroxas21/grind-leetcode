package org.coding.practice.questions.Arrays;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 228. Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
     "a->b" if a != b
     "a" if a == b

 Example 1:

 Input: nums = [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: The ranges are:
 [0,2] --> "0->2"
 [4,5] --> "4->5"
 [7,7] --> "7"

 Example 2:

 Input: nums = [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: The ranges are:
 [0,0] --> "0"
 [2,4] --> "2->4"
 [6,6] --> "6"
 [8,9] --> "8->9"

 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0) {
            return res;
        }

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            int j = i;

            // expand range as long as element are consecutive(e.g. 1,2,3 and 6,7,8).
            while (j + 1 < nums.length && nums[j+1] == nums[j] + 1) {
                j++;
            }


            if (nums[j] == start) {
                res.add(String.valueOf(start));
            } else {
                res.add(start + "->" + nums[j]);
            }

            // move to next potential start of range
            i = j + 1;
        }
        return res;
    }
}
