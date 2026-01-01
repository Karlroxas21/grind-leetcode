package org.coding.practice.questions.Integers;

/**
 * 1015. Smallest Integer Divisible by K
 * <p>
 * Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.
 * Return the length of n. If there is no such n, return -1.
 * Note: n may not fit in a 64-bit signed integer.
 * <p>
 * Input: k = 1
 * Output: 1
 * Explanation: The smallest answer is n = 1, which has length 1.
 * <p>
 * Input: k = 2
 * Output: -1
 * Explanation: There is no such positive integer n divisible by 2.
 * <p>
 * Input: k = 3
 * Output: 3
 * Explanation: The smallest answer is n = 111, which has length 3.
 */
public class SmallestIntegerDivisibleByK {
    /**
     * ELI5 Explanation:
     * The Clever Trick
     * <p>
     * Since we only care about the remainder when we divide by k, we can do a little shortcut:
     * <p>
     * Start with remainder=1.
     * <p>
     * For the next number (11), you can just take the old remainder (1), multiply it by 10, and add 1. Then find the new remainder when you divide by k.
     * <p>
     * New Remainder=((Old Remainder×10)+1)(modk)
     * <p>
     * You keep doing this. If you ever hit a remainder of 0, that means you found a number of all 1s that is divisible by k. The number of steps you took is the length of that number.
     * <p>
     * Why it always works (or why it stops)
     * <p>
     * If k is divisible by 2 or 5, it can never divide a number that ends in 1 (which all our numbers do). So, you can stop right away and say -1.
     * <p>
     * If k doesn't have 2 or 5 as a factor, the remainders when dividing by k can only be 1,2,3,…,k−1. Since there are only k−1 possible non-zero remainders, if you calculate k remainders and none of them are 0, one remainder must have repeated. If the remainders start repeating, you'll never hit 0, and the search goes on forever, so the answer must be -1. This is guaranteed not to happen if k has no factors of 2 or 5, meaning a 0 remainder will eventually be found before the remainders repeat.
     */
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        long remainder = 0;
        int length = 0;

        for (int i = 1; i <= k; i++) {
            remainder = (remainder * 10 + 1) % k;
            length++;

            if (remainder == 0) {
                return length;
            }
        }
        return -1;
    }
}
