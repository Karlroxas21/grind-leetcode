package org.coding.practice.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    Given an integer numRows, return the first numRows of Pascal's triangle.

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:
    Input: numRows = 1
    Output: [[1]]

 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        // Declare result for later storing
        List<List<Integer>> result;

        // Handle edge case 0
        if (numRows == 0) {
            return new ArrayList<>();
        }

        // Intialize result and add 1 in edge case 1
        result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }

        // Handle edge case 2
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }

        // Iterate in the middle of n-th row
        for(int i = 2; i < numRows ; i++){
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
        }
        return result;
    }
}
