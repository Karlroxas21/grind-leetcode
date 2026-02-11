package org;

import org.dsa.Arrays.BubbleSort.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unsorted = {7, 12, 9, 11, 3};
        BubbleSort bubbleSort = new BubbleSort(unsorted);

        System.out.println(Arrays.toString(bubbleSort.sort()));
    }
}
