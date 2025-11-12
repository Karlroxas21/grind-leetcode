package org.coding.practice.questions.strings;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // early exit condition if str1 and str2 is not the same as str2 and str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcdHelper(str1.length(), str2.length());

        return str1.substring(0, gcd);

    }

    private int gcdHelper(int length1, int length2) {
        while (length2 != 0) {
            int temp = length1 % length2;
            length1 = length2;
            length2 = temp;
        }
        return length1;
    }
}
