package org.coding.practice.questions.Arrays;

import java.util.*;

/**
 * 1122. Relative Sort Array
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 * Example 2:
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 */

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Instance of HashMap<I, I> countMap
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // List of integer to store remaining
        List<Integer> remaining = new ArrayList<>();
        // List of integer to store result
        List<Integer> result = new ArrayList<>();

        // Loop through arr2 to initialize only that's why we put 0 to value.
        for (int i = 0; i < arr2.length; i++) {
            countMap.put(arr2[i], 0);
        }

        // Loop through arr1 to check the occurrences on countMap to arr1
        // inside loop, if countMap contains the arr1[i] then `countMap.put(num, countMap.get(num) + 1)`
        // else add to remaining
        for (int i = 0; i < arr1.length; i++) {
            if (countMap.containsKey(arr1[i])) {
                countMap.put(arr1[i], countMap.get(arr1[i]) + 1);
            } else {
                remaining.add(arr1[i]);
            }
        }

        // Sort remaining using Collections.sort();
        Collections.sort(remaining);

        // Loop through arr2
        // Inside for loop, j < countMap.get(i) to check the occurrence of arr1 in arr2
        // Add num to result
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            for (int j = 0; j < countMap.get(num); j++) {
                result.add(arr2[i]);
            }
        }

        // Add remaining elements using result.addAll
        result.addAll(remaining);

        // return the results by converting to int[]
        return result.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue).toArray();
    }

}
