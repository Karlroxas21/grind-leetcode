package org.coding.practice.questions.strings;

/**
 * 1071. Greaatest Common Divisor of Strings
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // early exit condition if str1 and str2 is not the same as str2 and str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcdHelper(str1.length(), str2.length());

        return str1.substring(0, gcd);

    }

    /**
     *  GCD Formula
     *
     *  ELI5
     *  Imagine you have two numbers, say 12 and 18.
     *
     * You want to find all the numbers that can divide into 12 perfectly. These are the divisors of 12: 1,2,3,4,6,12.
     *
     * Next, you find all the numbers that can divide into 18 perfectly. These are the divisors of 18: 1,2,3,6,9,18.
     *
     * Now, look for the numbers that appear in both lists (the common divisors): 1,2,3,6.
     *
     * The largest one of these common divisors is the GCD. In this case, the Greatest Common Divisor of 12 and 18 is 6.
     */

    private int gcdHelper(int length1, int length2) {
        while (length2 != 0) {
            int temp = length1 % length2;
            length1 = length2;
            length2 = temp;
        }
        return length1;
    }
}
