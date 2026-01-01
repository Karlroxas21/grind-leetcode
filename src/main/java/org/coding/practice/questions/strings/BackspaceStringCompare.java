package org.coding.practice.questions.strings;

/**
 * 844. Backspace String Compare
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));

    }

    String helper(String val) {
        StringBuilder sb = new StringBuilder();

        for (char c : val.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) { // to ensure that we handle edge cases like # at first index
                sb.deleteCharAt(sb.length() -1);
            }
        }
        return sb.toString();
    }
}
