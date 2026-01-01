package org.coding.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 */

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result;

        result = new ArrayList<>();
        result.add(Arrays.asList((1)));
        if (rowIndex == 0) {
            return result.get(0);
        }

        result.add(Arrays.asList(1, 1));
        if (rowIndex == 1) {
            return result.get(1);
        }

        // Iterate in the middle of n-th row
        for(int i = 2; i <= rowIndex ; i++){
            // Get above/previous row
            List<Integer> prevRow = result.get(i - 1);

            List<Integer> currentRow = new ArrayList<>();

            // Flow is from left to right. Left and right most are always 1
            currentRow.add(1);

            // Iterate middle values. Get previous row size and add each indices.
            // For example: Index 0,1 and 1,2 is the one we want to add in row/level 3.
            for(int j = 0; j < prevRow.size() - 1; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j+1));
            }

            // Flow is from left to right. Left and right most are always 1
            currentRow.add(1);

            result.add(currentRow);
        };
        return result.get(result.size() -1);
    }
}
