package dsa.ArraysSelectionSort;

import org.dsa.Arrays.SelectionSort.SelectionSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        int[] arr = {7, 12, 9, 11, 3};
        int[] expected = {3, 7, 9, 11, 12};

        SelectionSort selectionSort = new SelectionSort(arr);

        int[ ] actual = selectionSort.sort();
        assertArrayEquals(expected, actual);
    }
}
