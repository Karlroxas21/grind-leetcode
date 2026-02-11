package dsa.Arrays.BubbleSort;

import org.dsa.Arrays.BubbleSort.BubbleSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubleSortTest {

    @Test
    void bubbleSort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BubbleSort bubbleSort = new BubbleSort(arr);

        int[] actual = bubbleSort.sort();
        assertArrayEquals(expected, actual);

    }
}
