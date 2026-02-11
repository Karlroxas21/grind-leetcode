package org.dsa.Arrays.BubbleSort;

public class BubbleSort {
    int[]  array;
    public BubbleSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        int length = array.length;

        // Loop through array
        // Compare current value to next value. Swap them if next value is higher.
        //
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
