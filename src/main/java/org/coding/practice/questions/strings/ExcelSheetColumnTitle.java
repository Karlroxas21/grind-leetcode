package org.coding.practice.questions.strings;

/**
 * EASY
 *
 * 168. Excel Sheet Column Title
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 *
 * Example 1:
 *
 * Input: columnNumber = 1
 * Output: "A"
 *
 * Example 2:
 *
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 *
 * Input: columnNumber = 701
 * Output: "ZY"
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            // subtract 1 to handle 1-based indexing of excel.
            columnNumber--;

            // Get remainder (0-25) and convert to A-Z. It uses ASCII Code.
            // columnNumber = 5
            // The ASCII value for 'A' is 65. For example: 65 + 5 = 70. We cast it as (char) to tell Java that this is not a number
            // and show me the letter of this address. 70 is 'F' in ASCII values.
            char letter = (char) ('A' + (columnNumber % 26));
            sb.append(letter);

            // Move on to next if present.
            columnNumber /= 26;

        }

        // reverse the string because on while loop we do right to left. If we don't reverse it, the result will be 'BA' instead of 'AB'.
        return sb.reverse().toString();
    }
}
