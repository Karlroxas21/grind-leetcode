package org.coding.practice.questions.HashTable;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Medium
 * 12. Integer to Roman
 * <p>
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
 * <p>
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
 * <p>
 * Given an integer, convert it to a Roman numeral.
 */
public class IntegerToRoman {
    /**
     * We use Greedy Algorithm here.
     * It doesn't look ahead to see how that choice will affect the future.
     * It simply grabs the biggest/best piece it can see right now.
     * <p>
     * In Integer to Roman, we used greedy algorithm by always subtracting the
     * largest poossible Roman Numeral value from the number.
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        // We use TreeMap with Reverse Order Comparator.
        // With this, it automatically sort its keys and by reversing the values,
        // we ensure it always hit the biggest number first.
        TreeMap<Integer, String> roman = new TreeMap<>(Collections.reverseOrder());
        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50, "L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");

        // Special cases
        roman.put(900, "CM");
        roman.put(400, "CD");
        roman.put(90, "XC");
        roman.put(40, "XL");
        roman.put(9, "IX");
        roman.put(4, "IV");

        // We cannot append roman numbers four times
        // If grater than 3,

        for (Map.Entry<Integer, String> entry : roman.entrySet()) {
            String symbol = entry.getValue();
            int val = entry.getKey();

            while (num >= val) {
                res.append(symbol);
                num -= val;
            }
        }

        return res.toString();
    }
}
