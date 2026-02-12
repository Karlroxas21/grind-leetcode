package org.dsa.Arrays.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        int length = arr.length;

        // Loop through array and find the smallest value
        for (int i = 0; i < length; i++) {
            int min = i;
            System.out.println("MIN VALUE: " + arr[min]);
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                System.out.println("min != i. " +  min + " " + i);
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                System.out.println("ARRAY: " + Arrays.toString(arr));
            }
            System.out.println("-----");
        }
        return arr;
    }
}
