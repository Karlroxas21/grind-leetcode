package org.coding.practice.questions.strings;

/**
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordInAString {
    public String reverseWords(String s) {
        // Trim the string (remove whitespaces) and split (convert to array of string) with multiple white spaces regex.
        String[] results = s.trim().split("\\s+");

        // we store result here.
        StringBuilder builder = new StringBuilder();

        // start the loop at the end of results.
        for (int i = results.length-1; i >= 0; i--) {
            // append space if it's not the end.
            if (i != 0) {
                builder.append(results[i].stripTrailing() + " ");
            } else {
                // we will not append white space if its the end.
                builder.append(results[i].stripTrailing());
            }
        }

        return builder.toString();
    }
}
