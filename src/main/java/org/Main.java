package org;

import org.dsa.Arrays.SelectionSort.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unsorted = {7, 12, 9, 11, 3,1,1};
        SelectionSort selectionSort = new SelectionSort(unsorted);

        System.out.println(Arrays.toString(selectionSort.sort()));

    }
}
