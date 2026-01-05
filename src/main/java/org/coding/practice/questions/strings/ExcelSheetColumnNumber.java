package org.coding.practice.questions.strings;

/**
 * 171. Excel Sheet Column Number
 * <p>
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * Example 1:
 * <p>
 * Input: columnTitle = "A"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: columnTitle = "AB"
 * Output: 28
 * <p>
 * Example 3:
 * <p>
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        char[] temp = columnTitle.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            result = result * 26 + (temp[i] - 'A' + 1);
        }

        return result;
    }
}
