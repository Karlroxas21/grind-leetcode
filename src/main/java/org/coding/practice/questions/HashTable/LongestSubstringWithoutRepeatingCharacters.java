package org.coding.practice.questions.HashTable;

import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest without duplicate characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> res = new HashSet<>();

        int maxLength = 0;

        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            // check of it's on hashset.
            while (res.contains(s.charAt(j))) {
                // if it is a duplicate, we must shrink the window from the left ('i').
                res.remove(s.charAt(i));

                // move pointer to right.
                i++;
            }
            // add unique value in our hash set
            res.add(s.charAt(j));

            // calculate the length
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

}
