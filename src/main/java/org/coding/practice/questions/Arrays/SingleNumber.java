package org.coding.practice.questions.Arrays;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *

 Input: nums = [2,2,1]
 Output: 1

 Input: nums = [4,1,2,1,2]
 Output: 4

 Input: nums = [1]
 Output: 1
 *
 */
public class SingleNumber {
    /**
     * ELI5:
     * This box has a very specific rule: "If you put something in that is already inside, POOF! Both of them disappear."
     *
     * Start: The box is empty (Value is 0).
     *
     * The Process: You start picking up numbers from the array one by one and throwing them into the box.
     *
     * You throw in a 5. (Box holds: 5)
     *
     * You throw in a 3. (Box holds: 5, 3)
     *
     * You throw in another 5. Because there is already a 5 inside, they cancel each other out and vanish! (Box holds: 3)
     *
     * The Result: Since every number has a twin except for one, all the twins will eventually meet inside the box and vanish.
     *
     *  The End: When you are done, the only thing left in the box is the single number that never found a partner to cancel it out.
     *
     * Technical:
     *
     * To understand why this works mathematically, we need to look at the properties of the Bitwise XOR (^) operation.
     *
     * 1. The Truth Table
     *
     * XOR stands for "Exclusive OR." It returns 1 only if the bits are different. If the bits are the same, it returns 0.
     * Bit A	Bit B	Result (A ^ B)
     * 0	0	0
     * 1	1	0
     * 0	1	1
     * 1	0	1
     *
     * Key Takeaway: When you XOR two identical bits (or numbers), the result is always 0.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = index ^ nums[i];
        }
        return index;
    }
}
