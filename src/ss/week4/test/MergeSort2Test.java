package ss.week4.test;

import org.junit.Test;
import ss.week4.MergeSort2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MergeSort2Test {
    @Test
    public void testMergesortEmptyList() {
        List<Integer> sequence = new ArrayList<>(Collections.emptyList());
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Collections.emptyList());
    }

    @Test
    public void testMergesortSingleItem() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1));
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1));
    }

    @Test
    public void testMergesortSortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5));

        sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testMergesortUnsortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4));
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5));

        sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 6, 5, 4));
        MergeSort2.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
