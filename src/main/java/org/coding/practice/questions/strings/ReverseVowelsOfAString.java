package org.coding.practice.questions.strings;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *

 Input: s = "IceCreAm"

 Output: "AceCreIm"

 Explanation:

 The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

 Input: s = "leetcode"

 Output: "leotcede"

 */

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        // Convert string to a array of chars. Because strings are immutable
        char[] chars = s.toCharArray();
        // initialize start to 0 and the of chars array
        int start = 0;
        int end = s.length() -1;
        // Vowels
        String vowels = "aeiouAEIOU";

        // Move pointers until they meet in the middle of the string.
        while (start < end) {

            // move towers the end of string.
            // if char is not vowel, add start(pointer).
            // if it is, process is below line 33
            while (start < end && vowels.indexOf(chars[start]) == -1) {
                start++;
            }

            // same here but it starts from end to start until they meet.
            while (start < end && vowels.indexOf(chars[end]) == -1) {
                end--;
            }

            // swap vowels found at the start and end positions.
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // move start and end pointer to continue searching for more vowels.
            start++;
            end--;
        }
        // convert back to string.
        return new String(chars);
    }
}
