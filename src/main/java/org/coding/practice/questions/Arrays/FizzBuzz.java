package org.coding.practice.questions.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean isDivisibleByThreeAndFive = i % 3 == 0 && i % 5 == 0;
            boolean isDivisibleByThree = i % 3 == 0;
            boolean isDivisibleByFive = i % 5 == 0;
            if (isDivisibleByThreeAndFive) {
                result.add("FizzBuzz");
            } else if (isDivisibleByThree) {
                result.add("Fizz");
            } else if (isDivisibleByFive) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
